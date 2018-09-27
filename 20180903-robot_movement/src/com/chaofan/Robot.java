package com.chaofan;

/**
 * Robot is the class representing the robot object
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public class Robot {
    private int X;
    private int Y;
    private String F;
    boolean isOnTable = false;
    private Table table;

    public void setTable(Table table) {
        this.table = table;
    }

    /**
     * This is the method to put the Robot on the table with coordinates (X,Y) and the forward direction (F)
     *
     * @param inValues a string which can be split into coordinate X and Y and forward direction like '1,1,NORTH'
     */
    public void PLACE(String inValues) {
        String[] values = inValues.split(",");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        String f = values[2];
        if (table != null) {
            if (this.table.isWithinRange(x, y)) {
                this.X = x;
                this.Y = y;
                this.F = f;
                this.isOnTable = true;
            }
        }
    }

    /**
     * method to get the table attribute
     * @return the table of this robot
     */
    public Table getTable() {
        return table;
    }

    /**
     * method to move the robot forward 1 unit in the forward direction
     */
    public void MOVE() {
        if (this.isOnTable) {
            int directionNum = Direction.indexOfDirection(this.F);
            int newX = this.X;
            int newY = this.Y;
            switch (directionNum) {
                case 0:
                    newY += 1;
                    break;
                case 1:
                    newX += 1;
                    break;
                case 2:
                    newY -= 1;
                    break;
                case 3:
                    newX -= 1;
                    break;
            }
            if (this.table.isWithinRange(newX, newY)) {
                this.X = newX;
                this.Y = newY;
            }
        }
    }

    /**
     * method to rotate the robot of 90 degree in the LEFT direction
     */
    public void LEFT() {
        if (this.isOnTable) {
            this.F = Direction.rotateDirection(this.F, -1);
        }
    }

    /**
     * method to rotate robot of 90 degree in the RIGHT direction
     */
    public void RIGHT() {
        if (this.isOnTable) {
            this.F = Direction.rotateDirection(this.F, 1);
        }
    }

    /**
     * This is the method to output the coordinates and forward direction of the Robot in a string
     *
     * @return the a string of the Robot's coordinates and forward direction
     */
    public String REPORT() {
        if (this.isOnTable){
            return String.format("\nOutput: %d,%d,%s", X, Y, F);
        }
        return "";
    }
}
