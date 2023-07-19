package ca.uwindsor.acc;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final Scanner scanner = Context.getInput();
    private static final PrintStream out = Context.getOutput();
    private static boolean initialRun = true;

    public static void run() {

        Initializer.initialize();

        while (true) {

            if (initialRun) {
                UserInterface.showMenu(true);
                initialRun = false;
            } else {
                UserInterface.showMenu(false);
            }

            int choice = Context.getInput().nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Search the keyword in the Inverse Index
                    String searchTerm = UserInterface.searchKeyword(scanner);

                    // Get the results
                    List<String> urls = Finder.search(searchTerm);
                    UserInterface.displayResultTable(urls);
                    break;
                case 2:
                    UserInterface.exitMessage();
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
