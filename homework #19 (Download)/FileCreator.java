package Download;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCreator {
    // загрузка нужного файла по ссылке
    public static void downloadFile(String url) throws Exception {
        URL urla = new URL(url);
        try (InputStream in = urla.openStream()) {
            Files.copy(in, Paths.get("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #19 (Download)\\src\\main\\java\\Download\\htmlFiles\\" + getFileName(url)));
        }
    }

    // получение имени файла
    public static String getFileName(String link) {
        String type = ".html";
        Pattern pattern = Pattern.compile("[a-z.\\-A-Z0-9]+[/]$");
        Matcher matcher = pattern.matcher(link);
        if (matcher.find()) {
//            System.out.println(link.substring(matcher.start(), matcher.end()-1) + type); // logs
            return (link.substring(matcher.start(), matcher.end()-1) + type);
        }
        return null;
    }
}
