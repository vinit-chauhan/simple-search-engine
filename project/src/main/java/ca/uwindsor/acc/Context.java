package ca.uwindsor.acc;

import java.io.PrintStream;
import java.util.Scanner;

public class Context {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    private static final PrintStream OUTPUT = new PrintStream(System.out);
    private static final Scanner INPUT = new Scanner(System.in);

    public static PrintStream getOutput() {
        return OUTPUT;
    }

    public static Scanner getInput() {
        return INPUT;
    }
}
