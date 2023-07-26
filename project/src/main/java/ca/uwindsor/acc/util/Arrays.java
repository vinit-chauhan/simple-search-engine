package ca.uwindsor.acc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arrays {
    public static List<String> clean(List<String> dirtyList) {
        return dirtyList.stream().filter(s -> !(s.isBlank() || s.isEmpty())).collect(Collectors.toList());
    }

    public static List<String> sort(List<String> words) {
        List<String> sortedList = new ArrayList<>(words);
        sortedList.sort(String::compareToIgnoreCase);
        return sortedList;
    }
}
