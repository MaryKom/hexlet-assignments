package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence.length() == 0) {
            return map;
        }
        String[] word = sentence.split(" ");
        for (String w: word) {
            if (map.get(w) == null) {
                map.put(w, 1);
            }
            else {
                int count = map.get(w);
                map.put(w, count + 1);
            }
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }

        String result = "{\n";
        for (Map.Entry<String, Integer> m: map.entrySet()) {
            result += "  " + m.getKey() + ": " + m.getValue() +"\n";
        }
        result += "}";
        return result;
    }
}
//END
