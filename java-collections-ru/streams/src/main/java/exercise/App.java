package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static Long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(name -> name.endsWith("gmail.com")||name.endsWith("yandex.ru")||name.endsWith("hotmail.com"))
                .count();
    }
}
// END
