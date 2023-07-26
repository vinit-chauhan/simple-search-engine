package ca.uwindsor.acc.processor;

import ca.uwindsor.acc.dictionary.CloseWordsFinder;
import ca.uwindsor.acc.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {

    public static List<String> search(String searchTerm, boolean isExactMatch) {
        if (isExactMatch) {
            // Returns list of exact search matches
            return Arrays.clean(InverseIndexer.search(searchTerm));
        } else {
            // set is used to remove the duplicate entries for closeWords.
            Set<String> resultSet = new HashSet<>();

            // Find the list of all the close words for the given search term.
            List<String> closeWords = CloseWordsFinder.closeWords(searchTerm, 2);

            closeWords.forEach(word -> resultSet.addAll(
                    Arrays.clean(InverseIndexer.search(word))
            ));
            return resultSet.stream().toList();
        }
    }
}
