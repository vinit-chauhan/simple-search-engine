package ca.uwindsor.acc.model;

import ca.uwindsor.acc.processor.WordFrequencyAnalyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class WebPage {
    private final String url;
    private final List<String> words;
    private Map<String, Integer> wordFrequency;

    public WebPage(String url, List<String> words) {
        this.url = url;
        this.words = words;
        this.wordFrequency = WordFrequencyAnalyzer.calculateWordFrequency(words);
    }

    public String getUrl() {
        return url;
    }

    public List<String> getWords() {
        return words;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    private void setWordFrequency(Map<String, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public List<Map.Entry<String, Integer>> getSortedWordFrequency() {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequency.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sortedEntries;
    }
}

