package at.htl.mavendemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.jvm.hotspot.HelloWorld;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager
            .getLogger(Main.class.getSimpleName());


    public static void main(String[] args) {
        System.out.println("Hello 3ahif");
        logger.info("Hello");
        parsehtml("http://en.wikipedia.org/");
    }

    public static void parsehtml(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            logger.info(doc.title());
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                System.out.printf(
                        "%s\t%s\n",
                        headline.attr("title"),
                        headline.absUrl("href")
                );
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
