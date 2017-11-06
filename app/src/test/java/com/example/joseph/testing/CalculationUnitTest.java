package com.example.joseph.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class CalculationUnitTest {

    Calculation calculation;

    //to create mock
    Addition addition;

    int val1, val2;

    public static final String ADDITION_STRING = "addition";
    public static final String CALULATION_STRING = "calculation";

    @Before
    public void setup(){

        //Addition mocked
        addition = mock(Addition.class);
        calculation = new Calculation(addition);
        val1 = 5;
        val2 = 10;
        calculation.setVal1(val1);
        calculation.setVal2(val2);

    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(15, calculation.addition());
    }

    @Test
    public void addTen_isCorrect() throws Exception {

        when(addition.add(val1,val2)).thenReturn(5);

        assertEquals(15, calculation.addTen());

        assertNotEquals(25, calculation.addTen());

    }

    @Test
    public void someString_test(){

        when(addition.additionString(ADDITION_STRING))
                //need to use Answer because we want to return an object String
                .thenAnswer(new Answer<String>() {
                    @Override
                    public String answer(InvocationOnMock invocation) throws Throwable {
                        return "some";
                    }
                });

        assertEquals("some" + CALULATION_STRING, calculation.calculationString(ADDITION_STRING, CALULATION_STRING));
    }

    @After
    public void tearDown(){
        calculation.clear();
    }

}