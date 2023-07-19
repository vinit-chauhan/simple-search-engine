package ca.uwindsor.acc.util.arrays;

import java.util.List;
import java.util.stream.Collectors;

public class Cleanup {
    public static List<String> clean(List<String> dirtyList) {
        return dirtyList.stream().filter(s -> !(s.isBlank() || s.isEmpty())).collect(Collectors.toList());
    }
}
