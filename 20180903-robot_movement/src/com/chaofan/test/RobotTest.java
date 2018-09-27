package com.chaofan.test;

import com.chaofan.Robot;
import com.chaofan.Table;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test class for Robot class
 */
public class RobotTest {

    /**
     * test for setTable method
     */
    @Test
    public void setTable() {
        Robot r  = new Robot();
        Table t = new Table(5,5);
        r.setTable(t);
        assertEquals(t, r.getTable());
    }

    /**
     * test for PLACE method
     */
    @Test
    public void PLACE() {
        Robot r  = new Robot();
        Table t = new Table(5,5);
        r.setTable(t);
        r.PLACE("1,1,NORTH");
        assertEquals("\n" +
                "Output: 1,1,NORTH", r.REPORT());
    }

    /**
     * test for MOVE method
     */
    @Test
    public void MOVE() {
        Robot r  = new Robot();
        Table t = new Table(5,5);
        r.setTable(t);
        r.PLACE("1,1,NORTH");
        r.MOVE();
        assertEquals("\n" +
                "Output: 1,2,NORTH", r.REPORT());
    }

    /**
     * test for LEFT method
     */
    @Test
    public void LEFT() {
        Robot r  = new Robot();
        Table t = new Table(5,5);
        r.setTable(t);
        r.PLACE("1,1,NORTH");
        r.LEFT();
        assertEquals("\n" +
                "Output: 1,1,WEST", r.REPORT());
    }

    /**
     * test for RIGHT method
     */
    @Test
    public void RIGHT() {
        Robot r  = new Robot();
        Table t = new Table(5,5);
        r.setTable(t);
        r.PLACE("1,1,NORTH");
        r.RIGHT();
        assertEquals("\n" +
                "Output: 1,1,EAST", r.REPORT());
    }

    /**
     * test for REPORT method
     */
    @Test
    public void REPORT() {
        Robot r  = new Robot();
        Table t = new Table(5,5);
        r.setTable(t);
        r.PLACE("0,0,NORTH");
        assertEquals("\n" +
                "Output: 0,0,NORTH", r.REPORT());
    }
}