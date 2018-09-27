package com.chaofan.test;

import com.chaofan.RegexHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * test class for RegexHandler class
 */
public class RegexHandlerTest {

    /**
     * test for matchAll method
     */
    @Test
    public void matchAll() {
        String str = "123\n456\n888\n";
        List<String> list = RegexHandler.matchAll(str, ".*\n");
        assertArrayEquals(new String[]{
                "123\n",
                "456\n",
                "888\n"
        },list.toArray());
    }
}