package ca.uwindsor.acc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {

    static String searchKeyword(Scanner scanner) {
        System.out.print("Enter the search keyword: ");
        return scanner.nextLine();
    }

    public static void exit() {
        System.out.println("Thank you for using the CLI. Goodbye!");
    }

    static void showMenu(boolean isInitialRun) {
        if (isInitialRun) {
            System.out.println("Welcome to the CLI!");
            System.out.println("1. Enter a search keyword");
        } else {
            // Display the options after the search
            System.out.println("Search completed.");
            System.out.println("1. Retry search");
        }

        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    static void displayResultTable(List<String> results) {
        // Display the URLs in a table format
        System.out.println("+--------------------------------------+");
        System.out.println("|             Search Results           |");
        System.out.println("+--------------------------------------+");
        System.out.println("|                  URL                 |");
        System.out.println("+--------------------------------------+");

        for (String url : results) {
            List<String> wrappedLines = wrapUrl(url, 36); // Maximum width for URL column

            for (String line : wrappedLines) {
                System.out.format("| %-36s |%n", line);
            }
        }

        System.out.println("+--------------------------------------+");
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



