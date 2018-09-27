package com.chaofan.test;

import com.chaofan.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * this is the unit test for Direction class
 */

public class DirectionTest {

    /**
     * test for indexOfDirection method
     */
    @Test
    public void indexOfDirection() {
        String direction = "NORTH";
        int index = Direction.indexOfDirection(direction);
        assertEquals(index, 0);
        direction = "SOUTH";
        index = Direction.indexOfDirection(direction);
        assertEquals(index, 2);
        direction = "EAST";
        index = Direction.indexOfDirection(direction);
        assertEquals(index, 1);
        direction = "WEST";
        index = Direction.indexOfDirection(direction);
        assertEquals(index, 3);
        direction = "error";
        index = Direction.indexOfDirection(direction);
        assertEquals(index, -1);
    }

    /**
     * test for rotateDirection
     */
    @Test
    public void rotateDirection() {
        String direction = "NORTH";
        direction = Direction.rotateDirection(direction, 1);
        assertEquals("EAST", direction);
        direction = Direction.rotateDirection(direction, -1);
        assertEquals("NORTH", direction);
        direction = Direction.rotateDirection(direction, -2);
        assertEquals("SOUTH", direction);
        direction = Direction.rotateDirection(direction, 3);
        assertEquals("EAST", direction);
        direction = Direction.rotateDirection(direction, 6);
        assertEquals("WEST", direction);
    }
}