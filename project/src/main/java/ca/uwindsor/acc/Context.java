package ca.uwindsor.acc;

import java.io.PrintStream;
import java.util.Scanner;

public class Context {
    private static final PrintStream output = new PrintStream(System.out);
    private static final Scanner input = new Scanner(System.in);

    public static PrintStream getOutput() {
        return output;
    }

    public static Scanner getInput() {
        return input;
    }
}
