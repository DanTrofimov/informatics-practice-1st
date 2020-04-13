package groupID;

import org.json.simple.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.charset.Charset;

public class StudentWriter {

    private FileWriter writer;

    // конструктор
    public StudentWriter(FileWriter writer) {
        this.writer = writer;
    }

    // метод для записи студента JSON
    public void writeStudent(Student student) throws IOException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", student.getName());
        jsonObj.put("date", student.getDate());
        jsonObj.put("gender", student.getGender());
        jsonObj.put("group", student.getGroup());
        writer.write(jsonObj.toJSONString());
    }

    // метод для записи студента YAML
    public void writeStudentYAML(Student student) {
        Yaml yaml = new Yaml();
        yaml.dump(student, writer);
    }

    // делегировали методы
    public String getEncoding() {
        return writer.getEncoding();
    }

    public void write(int c) throws IOException {
        writer.write(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        writer.write(cbuf, off, len);
    }

    public void write(String str, int off, int len) throws IOException {
        writer.write(str, off, len);
    }

    public Writer append(CharSequence csq, int start, int end) throws IOException {
        return writer.append(csq, start, end);
    }

    public Writer append(CharSequence csq) throws IOException {
        return writer.append(csq);
    }

    public void flush() throws IOException {
        writer.flush();
    }

    public void close() throws IOException {
        writer.close();
    }

    public static Writer nullWriter() {
        return Writer.nullWriter();
    }

    public void write(char[] cbuf) throws IOException {
        writer.write(cbuf);
    }

    public void write(String str) throws IOException {
        writer.write(str);
    }

    public Writer append(char c) throws IOException {
        return writer.append(c);
    }
}
