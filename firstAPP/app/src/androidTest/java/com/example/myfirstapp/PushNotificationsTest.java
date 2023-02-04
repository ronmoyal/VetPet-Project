package com.example.myfirstapp;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PushNotificationsTest {

    @Rule
    public ActivityTestRule<PushNotifications> mActivityTestRule = new ActivityTestRule<PushNotifications>(PushNotifications.class);
    private PushNotifications mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void TestLunchPushNotifications() {
        View view = mActivity.findViewById(R.id.title_id);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;

    }
}