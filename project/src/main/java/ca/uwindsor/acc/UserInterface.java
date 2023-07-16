package ca.uwindsor.acc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private static final int CONSOLE_LENGTH = 60;

    static String searchKeyword(Scanner scanner) {
        System.out.print("Enter the search keyword: ");
        return scanner.nextLine();
    }

    public static void exitMessage() {
        System.out.println("Thank you for using the Doogle CLI. Goodbye!");
    }

    public static void showMenu(boolean isInitialRun) {
        if (isInitialRun) {
            System.out.println("Welcome to the Doogle CLI!");
            System.out.println("1. Enter a search keyword");
        } else {
            // Display the options after the search
            System.out.println("Search completed.");
            System.out.println("1. Retry search");
        }

        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void displayResultTable(List<String> results) {
        Context.getOutput().print(drawResultTable(results));
    }

    private static String drawResultTable(List<String> results) {
        StringBuilder resultTable = new StringBuilder();

        // Create the result table and header rows
        addLine(CONSOLE_LENGTH, resultTable);
        addRowWithText(CONSOLE_LENGTH, "Search Results", resultTable);
        addLine(CONSOLE_LENGTH, resultTable);
        addRowWithText(CONSOLE_LENGTH, "URL", resultTable);
        addLine(CONSOLE_LENGTH, resultTable);

        // Add URLs in the result table
        addResult(CONSOLE_LENGTH, results, resultTable);
        addLine(CONSOLE_LENGTH, resultTable);

        return resultTable.toString();
    }

    private static void addLine(int length, StringBuilder sb) {
        sb.append("+-" + "-".repeat(length) + "-+").append(Context.LINE_SEPARATOR);
    }

    private static void addResult(int length, List<String> results, StringBuilder sb) {
        for (String url : results) {

            if (url == "") {
                addRowWithText(length, "No results found!", sb);
                continue;
            }

            List<String> wrappedLines = wrapUrl(url, length);
            for (String line : wrappedLines) {
                addResultLine(length, line, sb);
            }

        }
    }

    private static void addResultLine(int length, String text, StringBuilder sb) {
        sb.append(String.format("| %-" + length + "s |%n", text));
    }

    private static void addRowWithText(int length, String text, StringBuilder sb) {
        sb.append("| ")
                .append(" ".repeat((length - text.length()) / 2))
                .append(text)
                // add extra space at back to make vertical line consistant in case of odd text length
                .append(" ".repeat((length - text.length() + text.length() % 2) / 2))
                .append(" |")
                .append(Context.LINE_SEPARATOR);
    }

    private static List<String> wrapUrl(String url, int maxWidth) {
        List<String> wrappedLines = new ArrayList<>();
        int length = url.length();

        for (int i = 0; i < length; i += maxWidth) {
            int endIndex = Math.min(i + maxWidth, length);
            wrappedLines.add(url.substring(i, endIndex));
        }

        return wrappedLines;
    }
}



