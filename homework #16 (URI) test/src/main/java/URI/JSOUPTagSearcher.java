package URI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JSOUPTagSearcher {
    // 16.3 div-tag search https://o7planning.org/ru/10399/jsoup-java-html-parser-tutorial#a864736
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new File("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #16 (URI) test\\src\\main\\java\\html\\index.html"), "utf-8");
        Elements divs = doc.getElementsByTag("div");
        System.out.println(divs.size());
    }
}