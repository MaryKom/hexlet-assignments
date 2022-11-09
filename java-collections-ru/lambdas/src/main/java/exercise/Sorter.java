package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> listMans) {
        return listMans.stream()
                .filter(gender -> gender.get("gender").equals("male"))
                .sorted(Comparator.comparing(time -> time.get("birthday")))
                .map(name -> name.get("name"))
                .collect(Collectors.toList());
    }
}
// END
