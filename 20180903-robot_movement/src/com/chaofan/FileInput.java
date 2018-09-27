package com.chaofan;

import java.io.*;

/**
 * This is the class to handle methods related to Files
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public class FileInput {
    /**
     * method to get the content of a file based on a file path
     * @param filePath a path like 'C:/commands.txt'
     * @return the content of the file
     */
    public static String getFileContent(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        StringBuilder result = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                result.append(text).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
