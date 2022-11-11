package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        if (map1.isEmpty() && map2.isEmpty()) {
            return result;
        }
        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map2.get(key).equals(map1.get(key))) {
                    result.put(key, "unchanged");
                }
                else {
                    result.put(key, "changed");
                }
            }
            else {
                result.put(key, "deleted");
            }
        }
        for (String key: map2.keySet()) {
            if (!result.containsKey(key)) {
                result.put(key, "added");
            }
        }
        return result;
    }
}
//END
