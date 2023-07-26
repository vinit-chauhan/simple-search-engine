package ca.uwindsor.acc.processor;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    private static final List<String> IGNORE_WORDS = Arrays.asList(
            "a", "an", "the", "is", "are", "was", "were", "and", "or", "of", ":", "-"
    );

    // Add support for Nearest words.
    public static void tokenizer(String text, List<String> words) {
        String[] tokens = text.split("[ \n]+");
        for (String token : tokens) {
            String word = token.trim();
            if (word.length() > 0 && !IGNORE_WORDS.contains(word)) {
                // Remove Sensitive Data Such as Phone numbers and Email Addresses.
                if (isSafeToInsert(word))
                    words.add(word.replaceAll("[,.:]$", ""));
            }
        }
    }

    public static boolean isSafeToInsert(String text) {
        return !text.matches("^[a-zA-Z0-9]+([_.-][a-zA-Z-0-9]+)*@[a-zA-Z]+.([a-z]){2,}(.[a-z]+)*$") &&
                !text.matches("^([+][0-9]{1,3})?[0-9]{10}$") &&
                !text.matches("[)(*&^%$#@!~.,:]");
    }
}
