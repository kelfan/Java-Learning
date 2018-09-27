package com.chaofan.test;

import com.chaofan.MethodHandler;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * the class for test MethodHandler class
 */
public class MethodHandlerTest {

    /**
     * an inner class for testing
     */
    public class testObj {
        String result;

        /**
         * a simple method to change result
         */
        public void test() {
            result = "test method";
        }

        /**
         * a simple method to change result with parameter
         * @param param
         */
        public void test(String param) {
            result = "test " + param;
        }
    }

    /**
     * test callFunction with parameters
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void callFunctionWithParameters() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        testObj t = new testObj();
        MethodHandler.callFunction(t, "test", "something");
        assertEquals("test something", t.result);
    }

    /**
     * test call function
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void callFunction() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        testObj t = new testObj();
        MethodHandler.callFunction(t, "test");
        assertEquals("test method", t.result);
    }
}