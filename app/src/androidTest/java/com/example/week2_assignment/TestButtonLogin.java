package com.example.week2_assignment;
import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestButtonLogin {
    @Test
    public void testButtonTransition()
    {
        Intents.init();
        Espresso.onView(ViewMatchers.withId(R.id.activity_main_loginButton)).perform(ViewActions.click());
        Intents.release();
    }
}