import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileManager manager = new FileManager();
        System.out.println(manager.currentPath);
        manager.handler();
    }
}
