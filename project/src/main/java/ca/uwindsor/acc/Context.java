package ca.uwindsor.acc;

import java.io.PrintStream;
import java.util.Scanner;

public class Context {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String APP_NAME = "Doogle";

    private static final PrintStream out = new PrintStream(System.out);
    private static final Scanner in = new Scanner(System.in);

    public static PrintStream getOutput() {
        return out;
    }

    public static Scanner getInput() {
        return in;
    }

}
