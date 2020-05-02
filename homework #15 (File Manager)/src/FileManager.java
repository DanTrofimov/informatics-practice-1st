import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    private File currentFile;
    public String currentPath;
    private String[] commandsList = {"/help", "/cd..", "/cd <pathname>", "/exit", "/show", "/open", "/copy", "/delete"};

    // constructor
    public FileManager() {
        this.currentPath = System.getProperty("user.dir") + '\\' + "src";
        this.currentFile = new File(this.currentPath);
    }

    // shows all available commands
    public String help() {
        return "Available commands: " +
                Arrays.toString(commandsList).substring(1, Arrays.toString(commandsList).length() - 1);
    }

    // changes directory
    public String changeDirectory(String userPath) {
        Path newPath = Paths.get(userPath);
        File userFile = new File(newPath.toString());
        Path current = Paths.get(currentPath);
        try {
            if (!userFile.isAbsolute()) {
                File resultFile = new File(this.currentFile, newPath.toString()).getCanonicalFile();
                if (resultFile.exists()) {
                    currentFile = resultFile;
                    currentPath = currentFile.getAbsolutePath();
                    return currentPath;
                } else {
                    return "Incorrect path. Try again.";
                }
            } else {
                if (userFile.exists()){
                    currentFile = userFile.getAbsoluteFile();
                    currentPath = currentFile.getAbsolutePath();
                    return currentPath;
                }
                else{
                    return "Incorrect path. Try again.";
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "Incorrect path. Try again.";
    }

    // go back to the parent directory
    public String changeBack() {
        int len = currentPath.length();
        int index = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (currentPath.charAt(i) == '\\') {
                index = i;
                break;
            }
        }
        currentPath = currentPath.substring(0, index);
        return currentPath;
    }

    // exit from the manager
    public void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    // files in the current directory
    public String directoryFiles(){
        String[] files = new File(currentPath).list();
        for (String file : files) {
            System.out.println(file);
        }
        return currentPath;
    }

    // open file
    public String openFile(String nameFile) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File bufPath = new File(new File(currentPath) + "\\" + nameFile);
        if (bufPath.isFile()) {
            desktop.open(new java.io.File(bufPath.getAbsolutePath()));
        }
        return currentPath;
    }

    // copy file
    public String copyFile(String nameFile){
        File copy = new File(new File(currentPath) + "\\" + nameFile);
        String name1 = nameFile.substring(0, nameFile.lastIndexOf("."));
        String name2 = nameFile.substring(nameFile.lastIndexOf("."));
        File originalPath = new File(new File(currentPath) + "\\" + name1 + Math.round(Math.random() * 100) + name2);
        try {
            Files.copy(copy.toPath(), originalPath.toPath());
            System.out.println("Copied");
        } catch (IOException e) {
            System.out.println("Probably file is already exist");
        }
        return currentPath;
    }

    // delete file
    public String deleteFile(String nameFile){
        File deleting = new File(nameFile);
        if ((deleting.isAbsolute()) && deleting.isFile()){
            deleting.delete();
            System.out.println("Deleted");
        }
        else{
            deleting = new File(new File(currentPath) + "\\" + nameFile);
            if (deleting.isFile()) {
                deleting.delete();
                System.out.println("Deleted");
            }
        }
        return currentPath;
    }

    // FileManager commands handler
    public void handler() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileManager manager = new FileManager();
        while (true) {
            String input = sc.nextLine();
            if (input.split(" ").length > 2) {
                System.out.println("Incorrect input. Try again");
            } else {
                if (input.split(" ").length == 1) {
                    String command = input;
                    switch (command) {
                        case "/exit":
                            return;
                        case "/help":
                            System.out.println(manager.help());
                            break;
                        case "/cd..":
                            System.out.println(manager.changeBack());
                            break;
                        case "/show":
                            System.out.println(manager.directoryFiles());
                            break;
                        default:
                            System.out.println("Incorrect input. Try again");
                    }
                } else if (input.split(" ").length == 2) {
                    String command = input.split(" ")[0];
                    String path = input.split(" ")[1];
                    switch (command) {
                        case "/open":
                            manager.openFile(path);
                            break;
                        case "/cd":
                            System.out.println(manager.changeDirectory(path));
                            break;
                        case "/copy":
                            System.out.println(manager.copyFile(path));
                            break;
                        case "/delete":
                            System.out.println(manager.deleteFile(path));
                            break;
                        default:
                            System.out.println("Incorrect input. Try again");
                    }
                }
            }
        }
    }
}
