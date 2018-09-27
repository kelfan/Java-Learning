package com.chaofan;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * This is the Command Class to handle methods related to execute commands to a robot
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public class Command {
    static final String PLACE = "PLACE";
    static final String MOVE = "MOVE";
    static final String LEFT = "LEFT";
    static final String RIGHT = "RIGHT";
    static final String REPORT = "REPORT";
    static final String EXIT = "EXIT";

    private Robot robot;
    private String currentCmd = "";
    private int counter = 0;

    /**
     * constructor to initialize a command object
     */
    public Command() {
        // init a robot object
        Table table = new Table(5, 5);
        robot = new Robot();
        robot.setTable(table);
    }

    /**
     * execute a single block of command (from 'PLACE' order to 'REPORT' order)
     *
     * @param commandStr the String of commands
     * @return the command object for further actions
     */
    public Command execute(String commandStr) {
        currentCmd = commandStr;
        commandStr = commandStr.replace(Command.PLACE + "\n", Command.PLACE + " ");
        String[] commends = commandStr.split("\n");

        // run commands based inputs
        for (String cmd : commends) {
            if (cmd.contains(Command.PLACE)) {
                int index = cmd.lastIndexOf(Command.PLACE);
                cmd = cmd.substring(index);
            }
            String[] aLine = cmd.split(" ");
            try {
                if (aLine.length > 1) {
                    // use this way if the command has parameters
                    MethodHandler.callFunction(robot, aLine[0], aLine[1]);
                } else {
                    // use this way if the command doesn't have parameters
                    MethodHandler.callFunction(robot, aLine[0]);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                // ignore text if the text is not a command like 'PLACE, MOVE, LEFT, RIGHT, REPORT'
            }
        }
        return this;
    }

    /**
     * output the commands and result into console
     *
     * @return the string of output
     */
    public String output() {
        if (robot.isOnTable) {
            String out = String.format("\n%s)----------------\n" +
                    "%s\n" +
                    "%s\n", (char) (counter + 97), currentCmd, robot.REPORT());
            counter += 1;
            System.out.print(out);
            return out;
        }
        return "";
    }

    /**
     * output the result into console
     */
    public boolean outReport() {
        if (robot.isOnTable) {
            String out = String.format("%s\n", robot.REPORT());
            counter += 1;
            System.out.print(out);
            return true;
        }
        return false;
    }

    /**
     * execute multiple commands
     *
     * @param commandStr the string of commands
     * @return result of output
     */
    public String multipleExecute(String commandStr) {
        List<String> commandList = RegexHandler.matchAll(commandStr, "PLACE[\\s\\S]*?REPORT");
        StringBuilder result = new StringBuilder();
        for (String aCommand : commandList) {
            result.append(execute(aCommand).output());
        }
        return result.toString();
    }
}
