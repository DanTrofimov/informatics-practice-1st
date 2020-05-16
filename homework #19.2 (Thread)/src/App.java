import java.util.Scanner;

public class App {

    public static ThreadDownloader downloader;
    public String[] COMMANDS = {"/stop", "/progress", "/begin"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            commandHandler(input);
        }
    }

    public static void commandHandler(String command) {
        switch (command) {
            case "/stop":
                downloader.interrupt();
                System.out.println("Download finished");
                break;
            case "/begin":
                downloader = new ThreadDownloader();
                downloader.start();
                break;
            case "/progress":
                System.out.println(getProgress());
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    public static String getProgress() {
        double result = ((double) downloader.currentSize/downloader.SIZE);
        return Math.round(result*100) + "%";
    }
}
