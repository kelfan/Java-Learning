package com.chaofan.test;

import com.chaofan.FileHandler;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test for FileHandler class
 */
public class FileHandlerTest {

    /**
     * test for getAbsolutePath
     */
    @Test
    public void getAbsolutePath() {
        String file = "test.txt";
        String path = FileHandler.getAbsolutePath(file);
        assertTrue(path.contains("robot_movement/" + file));
        file = "/test.txt";
        path = FileHandler.getAbsolutePath(file);
        assertTrue(path.contains("robot_movement" + file));
        file = "\\test.txt";
        path = FileHandler.getAbsolutePath(file);
        assertTrue(path.contains("robot_movement" + file));
    }

    /**
     * test for getTestFile
     */
    @Test
    public void getTestFile() {
        String path = FileHandler.getTestFile();
        assertTrue(path.contains("robot_movement/src/com/chaofan/test/inputs.txt"));
    }
}