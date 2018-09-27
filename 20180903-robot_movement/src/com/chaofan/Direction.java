package com.chaofan;

/**
 * this is the class to handle methods related to directions
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public abstract class Direction {
    private static final String[] directions = {"NORTH", "EAST", "SOUTH", "WEST"};

    /**
     * this is the method to get the Index of a direction through a String
     *
     * @param direct a String of direction like 'NORTH'
     * @return the Index of the direction
     */
    public static int indexOfDirection(String direct) {
        for (int i = 0; i < directions.length; i++) {
            if (direct.toUpperCase().equals(directions[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * this is the method to get the direction after the rotation by number of degree
     * (positive number is clockwise direction while negative number is anticlockwise direction)
     *
     * @param origin the origin direction like 'NORTH'
     * @param num    the number of units to rotate like '1' and can be negative like '-1'. 1 unit equals to 90 degree.
     * @return the direction after rotation
     */
    public static String rotateDirection(String origin, int num) {
        int directionIndex = indexOfDirection(origin);
        directionIndex += num + directions.length;
        directionIndex %= directions.length;
        return directions[directionIndex];
    }
}
