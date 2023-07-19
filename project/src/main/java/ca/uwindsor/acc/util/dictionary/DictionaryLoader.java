package ca.uwindsor.acc.util.dictionary;

import ca.uwindsor.acc.util.file.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryLoader {
    private static List<String> dict = new ArrayList<>();

    public static void initialize() {
        // Create a hashtable ( buckets ) for list of words from first letter.
        String file = "project/src/main/resources/dictionaries/english.list";
        try {
            dict = Reader.readLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> load() {
        return dict;
    }
}
