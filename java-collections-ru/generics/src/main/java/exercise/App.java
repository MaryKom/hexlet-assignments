package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> words) {
        List<Map<String, String>> result = new ArrayList<>();
        for (var book: books) {
            boolean flag = true;
            for (var word: words.entrySet()) {
                if (!words.get(word.getKey()).equals(book.get(word.getKey()))) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
