package ca.uwindsor.acc.fetcher;

import ca.uwindsor.acc.processor.Tokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebScraper {

    public static String readHTMLFromURL(String website) {
        String html = urlToHTML(website);
        Document doc = Jsoup.parse(html);

        String text = doc.text();
        String title = doc.title();

        createTextFile(doc.title(), doc.text(), website);
        return doc.outerHtml();
    }

    public static String urlToHTML(String link) {
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(4500);
            conn.setReadTimeout(4500);
            Scanner sc = new Scanner(conn.getInputStream());
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(" ").append(sc.next());
            }

            String result = sb.toString();
            sc.close();
            return result;
        } catch (IOException e) {
            System.out.println(e);
        }
        return link;
    }

    public static void createTextFile(String title, String text, String link) {
        try {
            String[] titlesplit = title.split("\\|");
            StringBuilder newTitle = new StringBuilder();
            for (String s : titlesplit) {
                newTitle.append(" ").append(s);
            }
            //Checking if the DIR already exists
            File directory = new File("convertedWebPages");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File f = new File("convertedWebPages/" + newTitle + ".txt"); // create text file in convertedWebPages
            // folder
            f.createNewFile();
            PrintWriter pw = new PrintWriter(f);
            pw.println(link);
            pw.println(text);
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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
