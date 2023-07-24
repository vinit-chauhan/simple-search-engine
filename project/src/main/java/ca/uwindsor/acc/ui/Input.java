package ca.uwindsor.acc.ui;

import java.util.Scanner;

public class Input {

    public static String getSearchTerm(Scanner scanner) {
        System.out.print("Enter the search keyword: ");
        return scanner.nextLine();
    }
}
