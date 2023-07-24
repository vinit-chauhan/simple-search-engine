package ca.uwindsor.acc.processor;

import ca.uwindsor.acc.dictionary.CloseWordsFinder;
import ca.uwindsor.acc.util.arrays.Cleanup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {

    public static List<String> search(String searchTerm, boolean isExactMatch) {
        if (isExactMatch) {
            // Returns list of exact search matches
            return Cleanup.clean(InverseIndexer.find(searchTerm));
        } else {
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
}
