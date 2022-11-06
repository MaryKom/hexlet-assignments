package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence.length() == 0) {
            return map
        }
        String[] word = sentence.split(" ");
        for (String w: word) {
            int count = map.get(w);
            if (count == null) {
                map.put(w, 0)
            }
            else {
                map.put(w, count + 1);
            }
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        String result = "";
        for (Map.Entry<String, String> m: map.entrySet()) {
            result += "  " + m.getKey() + ": " + m.getValue() +"\n";
        }
        return result;
    }
}
//END
