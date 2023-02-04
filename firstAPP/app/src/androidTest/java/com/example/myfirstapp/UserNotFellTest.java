package com.example.myfirstapp;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.myfirstapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UserNotFellTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void userNotFellTest() {

try {
 Thread.sleep(7000);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
        
        ViewInteraction materialButton = onView(
allOf(withId(R.id.btn_login), withText("Login Client"), isDisplayed()));
        materialButton.perform(click());
        

try {
 Thread.sleep(700);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.et_email), isDisplayed()));
        appCompatEditText.perform(replaceText("kobi20@gmail.com"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.et_password), isDisplayed()));
        appCompatEditText2.perform(replaceText("12345678"), closeSoftKeyboard());
        
        ViewInteraction materialButton2 = onView(
allOf(withId(R.id.btn_login), withText("Log in"), isDisplayed()));
        materialButton2.perform(click());

try {
 Thread.sleep(7000);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
        
        ViewInteraction materialButton3 = onView(
allOf(withId(R.id.btn_NFWell), withText("Not Felling Well"), isDisplayed()));
        materialButton3.perform(click());
        

try {
 Thread.sleep(700);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.EDITsub), isDisplayed()));
        appCompatEditText3.perform(replaceText("dadas"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.editBody), isDisplayed()));
        appCompatEditText4.perform(replaceText("adsadadas"), closeSoftKeyboard());
        
        ViewInteraction materialButton4 = onView(
allOf(withId(R.id.saveNFW), withText("send"), isDisplayed()));
        materialButton4.perform(click());
        }
    }
