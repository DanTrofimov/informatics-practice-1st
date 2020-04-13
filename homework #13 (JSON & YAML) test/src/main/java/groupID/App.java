package groupID;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Student student = new Student("John", "male",  1984, 902);
        Student student1 = new Student("Lia", "female", 1991, 901);
        File JSONpath = new File("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #13 (JSON & YAML) test\\src\\main\\java\\groupID\\package.json");
        File YAMLpath = new File("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\REMOTE\\homework #13 (JSON & YAML) test\\src\\main\\java\\groupID\\package.yaml");
        // запись JSON
        try {
            StudentWriter out = new StudentWriter(new FileWriter(JSONpath));
            out.writeStudent(student);
            out.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // чтение JSON
        try {
            StudentReader in = new StudentReader(new FileReader(JSONpath));
            System.out.println(in.readStudent().toString());
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
        // запись YAML
        try {
            StudentWriter out = new StudentWriter(new FileWriter(YAMLpath));
            out.writeStudentYAML(student1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // чтение YAML
        try {
            StudentReader in = new StudentReader(new FileReader(YAMLpath));
            System.out.println(in.readStudentYAML());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}