package ca.uwindsor.acc;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    private static final List<String> IGNORE_WORDS = Arrays.asList(
            "a", "an", "the", "is", "are", "was", "were", "and", "or", "of", ":", "-"
    );

    // Add support for Nearest words.
    public static boolean tokenizer(String text, List<String> words) {
        String[] tokens = text.split("\\W+");
        for (String token : tokens) {
            String word = token.trim();
            if (word.length() > 0 && !IGNORE_WORDS.contains(word)) {
                words.add(word);
            }
        }
        return true;
    }

}
