package ca.uwindsor.acc;

import ca.uwindsor.acc.util.arrays.Cleanup;
import ca.uwindsor.acc.util.dictionary.CloseWordsFinder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {

    public static List<String> search(String searchTerm) {
        // set is used to remove the duplicate entries for closeWords.
        Set<String> resultSet = new HashSet<>();

        // Find the list of all the close words for the given search term.
        List<String> closeWords = CloseWordsFinder.closeWords(searchTerm, 1);

        closeWords.forEach(word -> resultSet.addAll(
                Cleanup.clean(InverseIndexer.find(word))
        ));
        return resultSet.stream().toList();
    }
}
