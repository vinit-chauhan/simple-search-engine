package ca.uwindsor.acc.processor.dictionary;

import ca.uwindsor.acc.util.edit_distance.Sequences;

import java.util.ArrayList;
import java.util.List;

public class CloseWordsFinder {
    public static List<String> closeWords(String term, int closeness) {
        List<String> closeWords = new ArrayList<>();
        for (String word : DictionaryLoader.load()) {
            if (Sequences.editDistance(term, word) <= closeness) {
                closeWords.add(word);
            }
        }
        return closeWords;
    }
}
