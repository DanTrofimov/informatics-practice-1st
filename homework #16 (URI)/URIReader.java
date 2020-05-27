package URI;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class URIReader {
    // 16.2 read file -> define type -> write
    public static void main(String[] args) throws URISyntaxException {
       // paths
       URI uri = new URI("https://css-tricks.com");
       File outputDefault = new File("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #16 (URI)\\src\\main\\java\\URI\\output");
       // write into the file
       try (BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
           FileWriter out = new FileWriter(outputDefault)) {
           String line;
           // type of file
           String type = uri.toURL().openConnection().getContentType();
           while ((line = in.readLine()) != null) {
               out.write(line);
               out.write("\n");
           }
           // add type to the name
           File outputNew = new File(outputDefault.getParent() + "output" + type.split("/")[1]); //text/html; charset=UTF-8
           Files.copy(outputDefault.toPath(), outputNew.toPath());
       } catch (IOException ex0) {
           System.out.println(ex0.getMessage());
       }
    }
}
