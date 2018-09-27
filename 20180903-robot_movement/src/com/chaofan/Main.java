package com.chaofan;

import java.io.File;

/**
 * Main Class to start and run the program
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public class Main {

    /**
     * main method of the program
     * @param args no parameters need for running this program
     */
    public static void main(String[] args) {

        // input variables
        final String STIN = "standardInput"; // Constant string to represent the type of standard input
        final String FILEIN = "fileInput"; // Constant string to represent the type of file text input
        String inputType = STIN; // change this between STIN and FILEIN to switch between standard input and file text input
        String filePath = FileHandler.getAbsolutePath(FileHandler.TEST_FOLDER + "inputs.txt");

        // switch between standard input and file text input
        String commendStr = "";
        if (inputType.equals(FILEIN)) {
            commendStr = FileInput.getFileContent(filePath);
            // execute commands and output result
            new Command().multipleExecute(commendStr);
        } else {
            StandardInput.startConsole();
        }


    }
}
