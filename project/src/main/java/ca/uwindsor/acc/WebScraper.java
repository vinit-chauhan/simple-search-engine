package ca.uwindsor.acc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    public String readHTMLFromURL(String website) throws IOException {
        Document doc = Jsoup.connect(website).get();
        return doc.outerHtml();
    }

    public List<String> extractWords(String html) {
        List<String> words = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.body().select("*");
        for (Element element : elements) {
            String text = element.ownText().toLowerCase();
            Tokenizer.tokenizer(text, words);
        }
        return words;
    }
}
