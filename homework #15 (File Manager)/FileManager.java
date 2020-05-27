import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    private File currentFile;
    public String currentPath;
    private String[] commandsList = {"/help", "/cd..", "/cd <pathname>", "/exit", "/files", "/open", "/copy", "/delete", "/show"};

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
            desktop.open(new File(bufPath.getAbsolutePath()));
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

    // shows what file contains
    public String showContent(String nameFile) {
        StringBuilder fileContent = new StringBuilder();
        String pathString = currentPath + "\\" + nameFile;
        Path path = Paths.get(pathString);
        path.normalize();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path.toString()), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line);
                fileContent.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileContent.toString();
    }

    // shows what file contains with considering charset
    public String showContent(String nameFile, String charsetName) {
        StringBuilder fileContent = new StringBuilder();
        String pathString = currentPath + "\\" + nameFile;
        Path path = Paths.get(pathString);
        path.normalize();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path.toString()), charsetName))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line);
                fileContent.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileContent.toString();
    }

    // FileManager commands handler
    public void handler() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileManager manager = new FileManager();
        while (true) {
            String input = sc.nextLine();
            if (input.split(" ").length > 3) {
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
                        case "/files":
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
                        case "/show":
                            System.out.println(manager.showContent(path));
                            System.out.println("That is the end of file");
                            break;
                        default:
                            System.out.println("Incorrect input. Try again");
                    }
                } else if (input.split(" ").length == 3) {
                    String command = input.split(" ")[0];
                    String path = input.split(" ")[1];
                    String charset = input.split(" ")[2];
                    switch (command) {
                        case "/show":
                            System.out.println(manager.showContent(path, charset));
                            System.out.println("That is the end of file");
                            break;
                        default:
                            System.out.println("Incorrect input. Try again");
                    }
                }
            }
        }
    }
}
