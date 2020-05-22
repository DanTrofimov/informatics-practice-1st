/*
TODO:  Сделать приложение, которое скачивает файл из инета (файл должен быть большим, чтобы скачивался около 10 секунд)
 пара потоков (1- скачивает) ( 2- слушает команды пользователя)
        3 команды :
        -начать скачивание
        -посмотреть сколько процентов скачано
        -отрубить скачивание
        ...если пользователь не завершил скачивание, то сказать ему, что скачивание завершилось.
 */

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ThreadDownloader extends Thread {
    public int currentSize = 0;
    public int SIZE = 2944;

    // downloading
    public void run() {
        try {
            URL url = new URL("https://chackydude.github.io/todo.js/");
            File file = new File("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #19.2 (Thread)\\src\\parsed");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath())));;
            URLConnection connection = url.openConnection();
            BufferedReader  reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String currentLine;
            int counter = 0;
            while ((currentLine = reader.readLine()) != null) {
                if (isInterrupted()) {
                    return;
                }
                writer.write(currentLine);
                writer.write("\n");
                writer.flush();
                currentSize = (int) file.length();
//                System.out.println(App.getProgress());
            }
            System.out.println("Download finished");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
