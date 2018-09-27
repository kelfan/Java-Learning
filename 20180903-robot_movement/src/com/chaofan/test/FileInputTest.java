package com.chaofan.test;

import com.chaofan.FileHandler;
import com.chaofan.FileInput;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * This is the test class to test the procedures based on the requirements
 */
public class FileInputTest {

    /**
     * test for getFileContent method
     */
    @Test
    public void getFileContent() {
        String filePath = FileHandler.getTestFile();
        String fileContent = FileInput.getFileContent(filePath);
        assertEquals("PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 1,2,EAST\n" +
                "MOVE\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n", fileContent);
    }
}