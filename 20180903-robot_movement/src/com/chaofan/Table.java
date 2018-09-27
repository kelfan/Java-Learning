package com.chaofan;

/**
 * This is class to define the table for the robot to move around
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public class Table {
    private int length;
    private int width;

    /**
     * constructor to define the length and width of the table
     *
     * @param length the length of the table
     * @param width  the width of the table
     */
    public Table(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * method to check whether a coordinate is in the range or not
     *
     * @param x horizontal coordinate
     * @param y vertical coordinate
     * @return true if the coordinate is in the range, otherwise false
     */
    public boolean isWithinRange(int x, int y) {
        if (x > this.width || x < 0) {
            return false;
        }
        return y <= this.length && y >= 0;
    }

    /**
     * method to check whether an Object equals to this table or not
     * @param obj the Object to be compared
     * @return true if the object equals to this table, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Table table = (Table) obj;
            return this.length == table.length && this.width == table.width;
        }
        return false;
    }
}
