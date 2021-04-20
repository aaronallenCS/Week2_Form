package com.example.week2_assignment;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkEmailValidation()
    {
        String testEmail = "hahaha@email.com";
        MainActivity m = new MainActivity();

        //pass test
        assertEquals(true, m.emailValidator(testEmail));

        String falseEmail = "aaaa";
        //failed test
        assertEquals(false, m.emailValidator(falseEmail));
    }
}