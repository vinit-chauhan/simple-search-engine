package ca.uwindsor.acc.ui;

import ca.uwindsor.acc.Context;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Output {
    private static final int CONSOLE_LENGTH = 120;

    private static final PrintStream out = Context.getOutput();

    public static void exitMessage() {
        out.println("Thank you for using the " + Context.APP_NAME + " CLI. Goodbye!");
    }

    public static void showMenu(boolean isInitialRun) {
        if (isInitialRun) {
            out.println("Welcome to the " + Context.APP_NAME + " CLI!");
            out.println("1. Enter a search keyword (Exact Search)");
            out.println("2. Enter a search keyword (Fuzzy Search)");
        } else {
            // Display the options after the search
            out.println("Search completed.");
            out.println("1. Retry search (Exact Search)");
            out.println("2. Retry search (Fuzzy Search)");
        }

        out.println("0. Exit");
        out.print("Enter your choice: ");
    }

    public static void displayResultTable(List<String> results) {
        Context.getOutput().print(drawResultTable(results));
    }

    private static String drawResultTable(List<String> results) {
        StringBuilder resultTable = new StringBuilder();

        // Create the result table and header rows
        addLine(CONSOLE_LENGTH, resultTable);
        addRowWithText("Search Results", resultTable);
        addLine(CONSOLE_LENGTH, resultTable);
        addRowWithText("URL", resultTable);
        addLine(CONSOLE_LENGTH, resultTable);

        // Add URLs in the result table
        addResult(results, resultTable);
        addLine(CONSOLE_LENGTH, resultTable);

        return resultTable.toString();
    }

    private static void addLine(int length, StringBuilder sb) {
        sb.append("+-").append("-".repeat(length)).append("-+").append(Context.LINE_SEPARATOR);
    }

    private static void addResult(List<String> results, StringBuilder sb) {
        if (results.size() == 0) {
            addRowWithText("No results found!", sb);
            return;
        }

        for (String url : results) {
            List<String> wrappedLines = wrapUrl(url);
            for (String line : wrappedLines) {
                addResultLine(line, sb);
            }
        }
    }

    private static void addResultLine(String text, StringBuilder sb) {
        sb.append(String.format("| * %-" + (Output.CONSOLE_LENGTH - 2) + "s |%n", text));
    }

    private static void addRowWithText(String text, StringBuilder sb) {
        sb.append("| ")
                .append(" ".repeat((Output.CONSOLE_LENGTH - text.length()) / 2))
                .append(text)
                // add extra space at back to make vertical line consistent in case of odd text length
                .append(" ".repeat((Output.CONSOLE_LENGTH - text.length() + text.length() % 2) / 2))
                .append(" |")
                .append(Context.LINE_SEPARATOR);
    }

    private static List<String> wrapUrl(String url) {
        List<String> wrappedLines = new ArrayList<>();
        int length = url.length();

        for (int i = 0; i < length; i += Output.CONSOLE_LENGTH) {
            int endIndex = Math.min(i + Output.CONSOLE_LENGTH, length);
            wrappedLines.add(url.substring(i, endIndex));
        }

        return wrappedLines;
    }
}



