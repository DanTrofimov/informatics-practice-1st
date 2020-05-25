package Tests;

import org.junit.Assert;
import org.junit.Test;

public class FileManagerTest {

    @Test
    public void help() {
        FileManager manager = new FileManager();
        String actual = manager.help();
        String expected = "Available commands: /help, /cd.., /cd <pathname>, /exit, /files, /open, /copy, /delete, /show";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void changeDirectory() {
        FileManager manager = new FileManager();
        String actual = manager.changeDirectory("incorrect path 123 !_. bag");
        String expected = "Incorrect path. Try again.";
        Assert.assertEquals(actual, expected);
    }
}
