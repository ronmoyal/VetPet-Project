package com.example.myfirstapp;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ClientScreenMainTest {

    @Rule
    public ActivityTestRule<ClientScreenMain> mActivityTestRule = new ActivityTestRule<ClientScreenMain>(ClientScreenMain.class);
    private ClientScreenMain mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void TestLunchClientScreenMain() {
        View view = mActivity.findViewById(R.id.welcomeClient);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}