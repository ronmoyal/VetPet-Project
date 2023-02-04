package com.example.myfirstapp;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class VetEditProfileTest {

    @Rule
    public ActivityTestRule<VetEditProfile> mActivityTestRule = new ActivityTestRule<VetEditProfile>(VetEditProfile.class);
    private VetEditProfile mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void TestLunchVetEditProfile() {
        View view = mActivity.findViewById(R.id.TVupdate);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}