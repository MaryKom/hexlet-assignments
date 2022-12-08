package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildAppartmentsList (List<Home> apartments, int n) {
        List<String> list = apartments.stream()
                .sorted((a1, a2) -> a1.compareTo(a2))
                .limit(n)
                .map(x -> x.toString())
                .collect(Collectors.toList());
        return list;
    }
}
// END
