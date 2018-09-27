package com.chaofan.test;

import com.chaofan.Command;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * this is the unit test for command class
 */

public class CommandTest {

    // variable to get console output for testing
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    /**
     * setup to get console output
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * setup to get console output
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * test for execute method
     */
    @Test
    public void execute() {
        String cmds = "PLACE 5,4,NORTH\n" +
                "MOVE\n" +
                "MOVE\n" +
                "error\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT";
        String result = new Command().execute(cmds).output();
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 5,4,NORTH\n" +
                "MOVE\n" +
                "MOVE\n" +
                "error\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 4,5,WEST\n", result);
    }

    /**
     * test for output method
     */
    @Test
    public void output() {
        String cmds = "REPORT\n" +
                "PLACE \n" +
                "REPORT\n" +
                "PLACE 1,1,NORTH\n" +
                "REPORT";
        String result = new Command().execute(cmds).output();
        assertEquals("\n" +
                "a)----------------\n" +
                "REPORT\n" +
                "PLACE \n" +
                "REPORT\n" +
                "PLACE 1,1,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "Output: 1,1,NORTH\n", result);
        cmds = "PLACE\nREPORT";
        result = new Command().execute(cmds).output();
        assertEquals("", result);
    }

    /**
     * test for outReport method
     */
    @Test
    public void outReport() {
        String cmds = "REPORT\n" +
                "PLACE \n" +
                "REPORT\n" +
                "PLACE 1,1,NORTH\n" +
                "REPORT";
        boolean result = new Command().execute(cmds).outReport();
        assertEquals("\nOutput: 1,1,NORTH\n", outContent.toString());
        assertTrue(result);
        cmds = "PLACE\nREPORT";
        result = new Command().execute(cmds).outReport();
        assertFalse(result);
    }

    /**
     * test for multipleExecute method
     */
    @Test
    public void multipleExecute() {
        String cmds = "REPORT\n" +
                "PLACE \n" +
                "REPORT\n" +
                "PLACE 1,1,NORTH\n" +
                "REPORT\n" +
                "PLACE 1,2,SOUTH\n" +
                "ERRO\n" +
                "REPORT";
        String result = new Command().multipleExecute(cmds);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 1,1,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "Output: 1,1,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 1,2,SOUTH\n" +
                "ERRO\n" +
                "REPORT\n" +
                "\n" +
                "Output: 1,2,SOUTH\n", result);
    }


}