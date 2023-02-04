package com.example.myfirstapp;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class adminScreenTest {

    @Rule
    public ActivityTestRule<adminScreen> mActivityTestRule = new ActivityTestRule<adminScreen>(adminScreen.class);
    private adminScreen mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void TestLunchAdminScreen() {
        View view = mActivity.findViewById(R.id.TVWellcome);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}