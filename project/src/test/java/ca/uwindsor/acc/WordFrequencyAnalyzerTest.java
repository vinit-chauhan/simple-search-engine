package ca.uwindsor.acc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordFrequencyAnalyzerTest {
    @Test
    void calculateWordFrequency() {
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzer();
        List<String> list = Arrays.asList("str1", "str2", "str1", "str3");
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("str1", 2);
        expectedMap.put("str2", 1);
        expectedMap.put("str3", 1);
        Map<String, Integer> actualMap = wordFrequencyAnalyzer.calculateWordFrequency(list);
        Assertions.assertNotNull(actualMap);
        Assertions.assertEquals(actualMap, expectedMap);
    }

    @Test
    void emptyListFrequencyTest() {
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzer();
        List<String> list = null;
        Map<String, Integer> actualOutput = null;
        try {
            actualOutput = wordFrequencyAnalyzer.calculateWordFrequency(list);
        } catch (NullPointerException e) {
            Assertions.assertNotNull(e);
        }
        Assertions.assertNull(actualOutput);
    }
}