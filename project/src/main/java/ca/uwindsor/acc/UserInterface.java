package ca.uwindsor.acc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private static final int CONSOLE_LENGTH = 120;

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
        for (String url : results) {

            if (url.equals("")) {
                addRowWithText("No results found!", sb);
                continue;
            }

            List<String> wrappedLines = wrapUrl(url);
            for (String line : wrappedLines) {
                addResultLine(line, sb);
            }

        }
    }

    private static void addResultLine(String text, StringBuilder sb) {
        sb.append(String.format("| * %-" + (UserInterface.CONSOLE_LENGTH - 2) + "s |%n", text));
    }

    private static void addRowWithText(String text, StringBuilder sb) {
        sb.append("| ")
                .append(" ".repeat((UserInterface.CONSOLE_LENGTH - text.length()) / 2))
                .append(text)
                // add extra space at back to make vertical line consistent in case of odd text length
                .append(" ".repeat((UserInterface.CONSOLE_LENGTH - text.length() + text.length() % 2) / 2))
                .append(" |")
                .append(Context.LINE_SEPARATOR);
    }

    private static List<String> wrapUrl(String url) {
        List<String> wrappedLines = new ArrayList<>();
        int length = url.length();

        for (int i = 0; i < length; i += UserInterface.CONSOLE_LENGTH) {
            int endIndex = Math.min(i + UserInterface.CONSOLE_LENGTH, length);
            wrappedLines.add(url.substring(i, endIndex));
        }

        return wrappedLines;
    }
}



