package com.chaofan.test;

import com.chaofan.Table;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test for Table class
 */
public class TableTest {
    /**
     * test for isWithinRange method
     */
    @Test
    public void isWithinRange() {
        Table table = new Table(5, 5);
        assertTrue(table.isWithinRange(1,1));
        assertFalse(table.isWithinRange(-1,-1));
        assertFalse(table.isWithinRange(1,-1));
        assertFalse(table.isWithinRange(-1,1));
        assertFalse(table.isWithinRange(6,1));
        assertFalse(table.isWithinRange(1,6));
        assertFalse(table.isWithinRange(6,6));
    }

    /**
     * test for equals method
     */
    @Test
    public void equals() {
        Table table1 = new Table(5, 5);
        Table table2 = new Table(5, 5);
        Table table3 = new Table(5, 6);
        assertEquals(table1, table2);
        assertNotEquals(table1, table3);
    }
}