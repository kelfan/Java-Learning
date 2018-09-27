package com.chaofan.test;

import com.chaofan.Command;
import com.chaofan.FileHandler;
import com.chaofan.FileInput;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * This is the test class to test the procedures based on the requirements
 */

public class MainTest {

    /**
     * Test for getting the same result as the examples in the requirements
     */
    @Test
    public void testRequirementExamples() {
        String str = "PLACE 0,0,NORTH\n" +
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
                "REPORT\n";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,1,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,WEST\n" +
                "\n" +
                "c)----------------\n" +
                "PLACE 1,2,EAST\n" +
                "MOVE\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 3,3,NORTH\n", result);
    }

    /**
     * test for requirements "The toy robot must not fall off the table during movement.  This also
     * includes the initial placement of the toy robot.  Any move that would cause
     * the robot to fall must be ignored."
     */
    @Test
    public void testPreventFalling() {
        String str = "PLACE 5,6,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 7,5,NORTH \n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,-1,NORTH \n" +
                "REPORT \n" +
                "\n" +
                "PLACE -1,0,NORTH \n" +
                "REPORT \n" +
                "\n" +
                "PLACE 5,5,NORTH\n" +
                "MOVE\n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "PLACE 5,5,EAST\n" +
                "MOVE\n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,5,WEST\n" +
                "MOVE \n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,5,NORTH \n" +
                "MOVE \n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,WEST \n" +
                "MOVE \n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,SOUTH \n" +
                "MOVE \n" +
                "REPORT \n" +
                "\n" +
                "PLACE 5,0,EAST \n" +
                "MOVE \n" +
                "REPORT \n" +
                "\n" +
                "PLACE 5,0,SOUTH \n" +
                "MOVE \n" +
                "REPORT ";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 5,5,NORTH\n" +
                "MOVE\n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 5,5,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 5,5,EAST\n" +
                "MOVE\n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 5,5,EAST\n" +
                "\n" +
                "c)----------------\n" +
                "PLACE 0,5,WEST\n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,5,WEST\n" +
                "\n" +
                "d)----------------\n" +
                "PLACE 0,5,NORTH \n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,5,NORTH\n" +
                "\n" +
                "e)----------------\n" +
                "PLACE 0,0,WEST \n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,WEST\n" +
                "\n" +
                "f)----------------\n" +
                "PLACE 0,0,SOUTH \n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,SOUTH\n" +
                "\n" +
                "g)----------------\n" +
                "PLACE 5,0,EAST \n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 5,0,EAST\n" +
                "\n" +
                "h)----------------\n" +
                "PLACE 5,0,SOUTH \n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "Output: 5,0,SOUTH\n", result);

    }

    /**
     * Test for requirement of input from file
     */
    @Test
    public void testInputFromFile() {
        String filePath = FileHandler.getTestFile();
        String str = FileInput.getFileContent(filePath);
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,1,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,WEST\n" +
                "\n" +
                "c)----------------\n" +
                "PLACE 1,2,EAST\n" +
                "MOVE\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 3,3,NORTH\n", result);
    }

    /**
     * Test for A robot that is not on the table can choose the ignore the MOVE, LEFT,
     * RIGHT and REPORT commands.
     */
    @Test
    public void testIgnoreActions() {
        String str = "ROBOT\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 1,1,NORTH\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 1,1,NORTH\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,2,WEST\n", result);
    }

    /**
     * Test for Where MOVE will move the toy robot one unit forward in the direction
     * it is currently facing.
     */
    @Test
    public void testMoveAction() {
        String str = "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 1,1,EAST\n" +
                "MOVE\n" +
                "MOVE\n" +
                "REPORT";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,1,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 1,1,EAST\n" +
                "MOVE\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 3,1,EAST\n", result);
    }

    /**
     * Test for Where LEFT and RIGHT will rotate the robot 90 degrees in the specified
     * direction without changing the position of the robot.
     */
    @Test
    public void testRotateAction() {
        String str = "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "LEFT\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "REPORT";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,WEST\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,SOUTH\n" +
                "\n" +
                "c)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,SOUTH\n" +
                "\n" +
                "d)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,EAST\n" +
                "\n" +
                "e)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,SOUTH\n" +
                "\n" +
                "f)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,SOUTH\n", result);
    }

    /**
     * Test for Where REPORT will announce the X,Y and F of the robot.  This can be
     * in any form, but standard output is sufficient.
     */
    @Test
    public void testReportAction() {
        String str = "REPORT\n" +
                "\n" +
                "PLACE\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT ";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,1,NORTH\n" +
                "\n" +
                "c)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "LEFT\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,WEST\n", result);
    }

    /**
     * Test for "It is required that the first command to the robot is a PLACE command,
     * after that, any sequence of commands may be issued, in any order, including
     * another PLACE command. The application should discard all commands in
     * the sequence until a valid PLACE command has been executed."
     */
    @Test
    public void testPlaceFirst() {
        String str = "REPORT\n" +
                "\n" +
                "LEFT\n" +
                "RIGHT\n" +
                "MOVE \n" +
                "REPORT\n" +
                "\n" +
                "PLACE\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 0,0,NORTH\n" +
                "REPORT ";
        String result = new Command().multipleExecute(str);
        assertEquals("\na)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,NORTH\n", result);
    }

    /**
     * Test for "Where PLACE will put the toy robot on the table in position X,Y and
     * facing NORTH, SOUTH, EAST or WEST.  The origin (0,0) can be considered to
     * be the SOUTH WEST most corner."
     */
    @Test
    public void testPlaceAction() {
        String str = "PLACE 0,0,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 1,1,SOUTH\n" +
                "REPORT\n" +
                "\n" +
                "PLACE 2,2,EAST\n" +
                "REPORT \n" +
                "\n" +
                "PLACE 3,3,WEST\n" +
                "REPORT";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 0,0,NORTH\n" +
                "REPORT\n" +
                "\n" +
                "Output: 0,0,NORTH\n" +
                "\n" +
                "b)----------------\n" +
                "PLACE 1,1,SOUTH\n" +
                "REPORT\n" +
                "\n" +
                "Output: 1,1,SOUTH\n" +
                "\n" +
                "c)----------------\n" +
                "PLACE 2,2,EAST\n" +
                "REPORT\n" +
                "\n" +
                "Output: 2,2,EAST\n" +
                "\n" +
                "d)----------------\n" +
                "PLACE 3,3,WEST\n" +
                "REPORT\n" +
                "\n" +
                "Output: 3,3,WEST\n", result);
    }

    /**
     * Test for "The robot is free to roam around the surface of the table, but must be
     * prevented from falling to destruction.  Any movement that would result
     * in the robot falling from the table must be prevented, however further
     * valid movement commands must still be allowed."
     */
    @Test
    public void testPreventAndValid() {
        String str = "PLACE 5,4,NORTH\n" +
                "MOVE\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT";
        String result = new Command().multipleExecute(str);
        assertEquals("\n" +
                "a)----------------\n" +
                "PLACE 5,4,NORTH\n" +
                "MOVE\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "\n" +
                "Output: 4,5,WEST\n", result);
    }
}