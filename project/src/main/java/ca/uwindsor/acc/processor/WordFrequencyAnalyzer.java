package ca.uwindsor.acc.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyAnalyzer {
    public static Map<String, Integer> calculateWordFrequency(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
