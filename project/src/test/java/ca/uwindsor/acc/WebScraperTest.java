package ca.uwindsor.acc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WebScraperTest {

    @Test
    public void testReadHTMLFromURL() throws IOException {
        WebScraper webScraper = new WebScraper();
        String website = "https://example.com";
        String html = webScraper.readHTMLFromURL(website);
        Assertions.assertNotNull(html);
        Assertions.assertTrue(html.contains("<html>"));
        Assertions.assertTrue(html.contains("</html>"));
    }

    @Test
    public void testExtractWords() {
        WebScraper webScraper = new WebScraper();
        String html = "<html><body>This is a sample text.</body></html>";
        List<String> expectedWords = Arrays.asList("this", "sample", "text");
        List<String> words = webScraper.extractWords(html);
        Assertions.assertEquals(expectedWords, words);
    }
}
