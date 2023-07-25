package ca.uwindsor.acc.dictionary;

import ca.uwindsor.acc.Context;
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
        for (String localWord : Context.localDictionary) {
            if (Sequences.editDistance(term, localWord) <= closeness) {
                closeWords.add(localWord);
            }
        }
        return closeWords;
    }
}
