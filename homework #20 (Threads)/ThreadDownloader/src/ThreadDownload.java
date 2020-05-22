import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;

public class ThreadDownload extends Thread {
    private URL link;
    private String type;
    private String path = "D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #20 (Threads)\\ThreadDownloader\\src";

    public ThreadDownload(URL name) {
        try {
            this.link = name;
            this.type = name.openConnection().getContentType();
        } catch (IOException e) {
            System.out.println("Uncorrected URL.");
        }
    }

    public void run() {
        try (InputStream in = link.openConnection().getInputStream()) {
            String[] types = type.split("[/;]");
            path = path + (Math.random() * 10)  + "." + types[1];
            OutputStream out = new FileOutputStream(path);
            ByteBuffer buf = ByteBuffer.allocate(5000);
            while (in.available() > 0 ){
                if (!(isInterrupted())) {
                    for (int i = 0; i < 6000; i++){
                        buf.put((byte) in.read());
                    }
                    buf.rewind();
                    out.write(buf.array());
                    buf.rewind();
                    Thread.sleep(100);
                }
                else{
                    throw new InterruptedException();
                }
            }
            System.out.println("Download end.");
        } catch (IOException e) {
            System.out.println("Uncorrected URL.");
        } catch (InterruptedException e) {
            System.out.println("Thread died.");
        }
    }


    public String getPath() {
        return path;
    }

    public URL getLink() {
        return link;
    }
}