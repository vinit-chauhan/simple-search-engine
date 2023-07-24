package ca.uwindsor.acc;

import ca.uwindsor.acc.processor.Finder;
import ca.uwindsor.acc.ui.Input;
import ca.uwindsor.acc.ui.Output;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final Scanner scanner = Context.getInput();
    private static final PrintStream out = Context.getOutput();
    private static boolean initialRun = true;

    public static void run() {

        Initializer.initialize();

        int choice = 0;
        while (true) {

            if (initialRun) {
                Output.showMenu(true);
                initialRun = false;
            } else
                Output.showMenu(false);


            try {
                choice = Context.getInput().nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                out.println("Invalid choice. Please try again.");
            }

            switch (choice) {
                case 1: {
                    // Search the keyword in the Inverse Index
                    String searchTerm = Input.getSearchTerm(scanner);
                    // Get the results
                    List<String> urls = Finder.search(searchTerm, true);
                    // print the search results
                    Output.displayResultTable(urls);
                    break;
                }
                case 2: {
                    // Search the keyword in the Inverse Index
                    String searchTerm = Input.getSearchTerm(scanner);
                    // Get the results
                    List<String> urls = Finder.search(searchTerm, false);
                    // print the search results
                    Output.displayResultTable(urls);
                    break;
                }
                case 0:
                    Output.exitMessage();
                    return;
                default:
                    out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static void main(String[] args) {
        run();
    }
}
