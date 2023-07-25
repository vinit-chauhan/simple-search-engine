package ca.uwindsor.acc;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Context {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String APP_NAME = "Doogle";
    public static final Set<String> localDictionary = new HashSet<>();
    private static final PrintStream out = new PrintStream(System.out);
    private static final Scanner in = new Scanner(System.in);

    public static PrintStream getOutput() {
        return out;
    }

    public static Scanner getInput() {
        return in;
    }

}
