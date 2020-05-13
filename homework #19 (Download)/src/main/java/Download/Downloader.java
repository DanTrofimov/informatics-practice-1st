package Download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.regex.Pattern;

/**
 * 19.3
 *
 */
public class Downloader {
    public static void main(String[] args) {
        String url = "https://css-tricks.com/";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            Elements media = doc.select("[src]");
            Elements imports = doc.select("link[href]");
            int stopper = 0;

            // вывод кол-ва ссылок
            print("\nLinks: (%d)", links.size());
            // обработка ссылок
            for (Element link : links) {
                if (stopper > 5) break;
                stopper++;
                Pattern pattern = Pattern.compile("https://css-tricks[a-z.\\-A-Z0-9]+");
                String currentLink = link.attr("abs:href");
                System.out.println(currentLink);
                if (pattern.matcher(currentLink).find()) {
                    try {
                        Thread.sleep(10);
                        FileCreator.downloadFile(currentLink);
                    } catch (Exception ex) {
                        System.out.println("Maybe something wrong with a file-link.");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Problems with connection.");
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}