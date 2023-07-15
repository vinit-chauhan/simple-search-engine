package ca.uwindsor.acc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Initializer {
    public static void initialize() {
        String[] websites = {
                "https://javarevisited.blogspot.com/2017/04/difference-between-priorityqueue-and-treeset-in-java.html",
                "https://en.wikipedia.org/wiki/Set_(abstract_data_type)#Language_support",
                "https://www.geeksforgeeks.org/difference-between-priorityqueue-and-treeset/"
        };

        WebScraper scraper = new WebScraper();
        List<WebPage> webPages = new ArrayList<>();

        for (String website : websites) {
            try {
                String html = scraper.readHTMLFromURL(website);
                List<String> words = scraper.extractWords(html);

                System.out.println(words.toString());

                WebPage webPage = new WebPage(website, words);
                webPages.add(webPage);
            } catch (IOException e) {
                System.err.println("Failed to scrape website: " + website);
            }
        }

        for (WebPage webPage : webPages) {
            InverseIndexer.buildInverseIndex(webPage);
        }
    }
}
