package ca.uwindsor.acc.fetcher;

import ca.uwindsor.acc.processor.Tokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    public static String readHTMLFromURL(String website) throws IOException {
        Document doc = Jsoup.connect(website).get();
        return doc.outerHtml();
    }

    public static List<String> extractWords(String html) {
        List<String> words = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.body().select("*");
        for (Element element : elements) {
            String text = element.ownText().toLowerCase();
            if (!text.isEmpty() && !text.isBlank())
                Tokenizer.tokenizer(text, words);
        }
        return words;
    }
}