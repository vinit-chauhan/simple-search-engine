package ca.uwindsor.acc;

import ca.uwindsor.acc.dictionary.DictionaryLoader;
import ca.uwindsor.acc.fetcher.WebScraper;
import ca.uwindsor.acc.model.WebPage;
import ca.uwindsor.acc.processor.InverseIndexer;
import ca.uwindsor.acc.util.file.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Initializer {
    public static void initialize() {
        String[] websites = Reader.defaultURLList();
        DictionaryLoader.initialize();

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
