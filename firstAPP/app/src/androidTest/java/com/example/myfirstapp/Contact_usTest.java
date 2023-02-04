package com.example.myfirstapp;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Contact_usTest {


    @Rule
    public ActivityTestRule<Contact_us> mActivityTestRule = new ActivityTestRule<Contact_us>(Contact_us.class);
    private Contact_us mActivity = null;


    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void TestLunchContact_us() {
        View view = mActivity.findViewById(R.id.edContact);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}