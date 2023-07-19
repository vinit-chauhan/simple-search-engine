package ca.uwindsor.acc.util.file;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;


public class Reader {

    public static String[] defaultURLList() {
        return new String[]{
                "https://javarevisited.blogspot.com/2017/04/difference-between-priorityqueue-and-treeset-in-java.html",
                "https://en.wikipedia.org/wiki/Set_(abstract_data_type)#Language_support",
                "https://www.geeksforgeeks.org/difference-between-priorityqueue-and-treeset/"
        };
    }

    public static List<String> readLines(String path) throws IOException {
        Path filePath = Paths.get(path);
        Charset charset = StandardCharsets.UTF_8;
        try (Stream<String> stream = lines(filePath, charset)) {
            return stream.collect(Collectors.toList());
        }
    }
}
