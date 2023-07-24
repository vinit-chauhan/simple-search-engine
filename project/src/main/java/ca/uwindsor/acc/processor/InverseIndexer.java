package ca.uwindsor.acc.processor;

import ca.uwindsor.acc.model.WebPage;

import java.util.*;
import java.util.stream.Collectors;

public class InverseIndexer {
    private static final Map<String, SortedMap<Integer, HashSet<String>>> inverseIndex = new HashMap<>();

    // Build inverse index
    public static void buildInverseIndex(WebPage webPage) {
        for (Map.Entry<String, Integer> wordFrequency : webPage.getWordFrequency().entrySet()) {
            SortedMap<Integer, HashSet<String>> treeMap;
            String word = wordFrequency.getKey();

            // Setup TreeMap for (Frequency, set[url])
            if (inverseIndex.get(word) == null) {
                treeMap = new TreeMap<>(Collections.reverseOrder());
                inverseIndex.put(word, treeMap);
            } else {
                treeMap = inverseIndex.get(word);
            }

            // Initialize the set of urls if it does not exist already else return existing set.
            HashSet<String> set = treeMap.get(wordFrequency.getValue());
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(webPage.getUrl());

            treeMap.put(wordFrequency.getValue(), set);
        }
    }

    public static Map<String, SortedMap<Integer, HashSet<String>>> getInverseIndex() {
        return inverseIndex;
    }

    public static List<String> find(String searchTerm) {
        List<String> searchHits = new ArrayList<>();
        SortedMap<Integer, HashSet<String>> resultMap = InverseIndexer
                .getInverseIndex()
                .get(searchTerm);

        // handle empty arrays case
        if (resultMap == null || resultMap.isEmpty()) {
            resultMap = new TreeMap<>();
            HashSet<String> set = new HashSet<>();
            set.add("");
            resultMap.put(1, set);
        }
        resultMap.entrySet()
                .stream()
                .limit(10)
                .collect(Collectors.toSet())
                .forEach(e -> searchHits.addAll(e.getValue()));
        return searchHits;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

