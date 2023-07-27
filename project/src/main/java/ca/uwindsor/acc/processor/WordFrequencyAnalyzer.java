package ca.uwindsor.acc.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyAnalyzer {
    public static Map<String, Integer> calculateWordFrequency(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Count the occurrences of each word in the input list
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Calculate and print the total number of unique words
        int uniqueWordsCount = wordFrequency.size();
//        System.out.println("Total Unique Words: " + uniqueWordsCount);

        // Calculate and print the most frequent word and its count
        String mostFrequentWord = "";
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentWord = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
//        System.out.println("Most Frequent Word: " + mostFrequentWord + " (Count: " + maxFrequency + ")");

        // Calculate and print the least frequent word and its count
        String leastFrequentWord = "";
        int minFrequency = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() < minFrequency) {
                leastFrequentWord = entry.getKey();
                minFrequency = entry.getValue();
            }
        }
//        System.out.println("Least Frequent Word: " + leastFrequentWord + " (Count: " + minFrequency + ")");

        return wordFrequency;
    }

}
