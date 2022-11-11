package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String config) {
        return Stream.of(config.split("\n"))
                .filter(x -> x.startsWith("environment="))
                .map(x -> x.replaceAll("environment=", ""))
                .flatMap(x -> Stream.of(x.split(",")))
                .map(x -> x.replaceAll("\"", ""))
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
