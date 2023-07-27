package ca.uwindsor.acc;

import ca.uwindsor.acc.dictionary.DictionaryLoader;
import ca.uwindsor.acc.fetcher.WebScraper;
import ca.uwindsor.acc.model.WebPage;
import ca.uwindsor.acc.processor.InverseIndexer;
import ca.uwindsor.acc.util.file.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ca.uwindsor.acc.Context.localDictionary;

public class Initializer {
    public static void initialize() {
        List<String> websites;

        String file = "project/src/main/resources/ingest/urls.list";
        try {
            websites = Reader.readLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DictionaryLoader.initialize();

        WebScraper scraper = new WebScraper();
        List<WebPage> webPages = new ArrayList<>();

        for (String website : websites) {
            String html = WebScraper.readHTMLFromURL(website.trim());
            List<String> words = WebScraper.extractWords(html);
            localDictionary.addAll(words);
            WebPage webPage = new WebPage(website, words);
            webPages.add(webPage);
        }

        for (WebPage webPage : webPages) {
            InverseIndexer.buildInverseIndex(webPage);
        }
    }
}
