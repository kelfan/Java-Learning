package com.chaofan;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is the class handle things from standard input
 *
 * @author Chaofan
 * @version 1.0
 * @since 2018-8-28
 */
public class StandardInput {
    /**
     * method to response to user's input in a console window
     */
    public static void startConsole() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        String input = "";

        outerLoop:
        while (true) {
            System.out.print(String.format("\n%s)----------------\n", (char) (counter + 97)));
            counter += 1;
            boolean hasStart = false;
            StringBuilder result = new StringBuilder();
            boolean hasExecuted = false;
            while (!hasExecuted) {
                try {
                    input = scanner.next();
                    if (input.equals(Command.PLACE)) {
                        hasStart = true;
                    }
                    if (hasStart) {
                        result.append(input).append("\n");
                    }
                    if (input.equals(Command.EXIT)) {
                        break outerLoop;
                    }
                    if (input.equals(Command.REPORT)) {
                        hasExecuted = new Command().execute(result.toString()).outReport();
                    }
                } catch (NoSuchElementException e) {
                    input = "";
                }
            }
            input = "";
        }

        scanner.close();
    }
}
