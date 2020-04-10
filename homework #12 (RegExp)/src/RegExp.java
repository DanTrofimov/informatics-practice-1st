import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        // TODO: определить является введеднная строка доменным именем
        System.out.println("enter domain:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Pattern pattern = Pattern.compile("^([^!?_-][A-Za-z0-9_-]{1,63}\\.)+[A-Za-z]{2,6}$");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());

        // TODO: вычленить все доиенные имена из текста
        String text = "example.ru is example of e-mail, also you can use eXaMpLe.hey.e91.com";
        pattern = Pattern.compile("\\s");
        String[] strings = pattern.split(text);
        pattern = Pattern.compile("^([^!?_-][A-Za-z0-9_-]{1,63}\\.)+[A-Za-z]{2,6}$",Pattern.MULTILINE);
        matcher = pattern.matcher(str);
        System.out.println("domains in the text:");
        for (String s : strings) {
            matcher = pattern.matcher(s);
            if (matcher.matches()) {
                System.out.println(s);
            }
        }

        //TODO: получить домены верхнего и нижнего уровня для e-mail
        System.out.println("enter e-mail:");
        str = input.nextLine();
        pattern  = Pattern.compile("(?:@([A-Za-z]{2,6}))|(?:(?:\\.[A-Za-z]{2,6}$))");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(str.substring(matcher.start()+1, matcher.end()));
        }
    }
}
