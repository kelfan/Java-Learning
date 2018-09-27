package com.chaofan;

import java.io.File;

/**
 * This is the class to handle file related functions
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */

public class FileHandler {

    public static final String TEST_FOLDER = "/src/com/chaofan/test/";

    /**
     * get the absolute path of a file based on the path of the program
     *
     * @param filename a filename with relative path like "/src/com/chaofan/test/inputs.txt"
     * @return the absolute path of the file like "c:/robot_movement/src/com/chaofan/test/inputs.txt"
     */
    public static String getAbsolutePath(String filename) {
        String basePath = new File("").getAbsolutePath();
        if (!filename.matches("[/\\\\].*")) {
            filename = "/" + filename;
        }
        return basePath + filename;
    }

    /**
     * get the test file's path for testing like "c:/robot_movement/src/com/chaofan/test/inputs.txt"
     *
     * @return
     */
    public static String getTestFile() {
        return getAbsolutePath(TEST_FOLDER + "inputs.txt");
    }
}
