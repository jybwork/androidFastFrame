package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }
    @Test
    public void addition_isCorrect() {
        // Context of the app under test.

        float aa = 1.00f;

        float bb = 1.5f;
        System.out.println(test(++aa,bb));
    }


    public static float  test(float i1 ,float a2){
        System.out.println(i1+"------"+a2);
        return i1>a2?a2:i1;
    }
}
