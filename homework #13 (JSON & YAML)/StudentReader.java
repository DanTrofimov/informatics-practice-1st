package groupID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.CharBuffer;

public class StudentReader {

    private FileReader reader;

    // конструктор
    public StudentReader(FileReader reader) {
        this.reader = reader;
    }

    // метод для чтения JSON
    public Student readStudent() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        String name = (String) jsonObject.get("name");
        String gender = (String) jsonObject.get("gender");
        long group = (long) jsonObject.get("group");
        long date = (long) jsonObject.get("date");
        return new Student(name, gender, date, group);
    }

    // метод для чтения YAML
    public Student readStudentYAML() {
        Student student = new Student();
        Yaml yaml = new Yaml();
        student = yaml.load(reader);
        return student;
    }

    // делигировали методы
    public String getEncoding() {
        return reader.getEncoding();
    }

    public int read() throws IOException {
        return reader.read();
    }

    public int read(char[] cbuf, int offset, int length) throws IOException {
        return reader.read(cbuf, offset, length);
    }

    public boolean ready() throws IOException {
        return reader.ready();
    }

    public void close() throws IOException {
        reader.close();
    }

    public static Reader nullReader() {
        return Reader.nullReader();
    }

    public int read(CharBuffer target) throws IOException {
        return reader.read(target);
    }

    public int read(char[] cbuf) throws IOException {
        return reader.read(cbuf);
    }

    public long skip(long n) throws IOException {
        return reader.skip(n);
    }

    public boolean markSupported() {
        return reader.markSupported();
    }

    public void mark(int readAheadLimit) throws IOException {
        reader.mark(readAheadLimit);
    }

    public void reset() throws IOException {
        reader.reset();
    }

    public long transferTo(Writer out) throws IOException {
        return reader.transferTo(out);
    }
}
