package ca.uwindsor.acc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Initializer {
    public static void initialize() {
        String[] websites = FileReader.readURLList();

        WebScraper scraper = new WebScraper();
        List<WebPage> webPages = new ArrayList<>();

        for (String website : websites) {
            try {
                String html = scraper.readHTMLFromURL(website);
                List<String> words = scraper.extractWords(html);

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
