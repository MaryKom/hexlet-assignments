package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;


// BEGIN
class App {
    public static void save (Path p, Car c) {
        String content = c.serialize();
        try {
            Files.write(p, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path filepath) {
        String content;
        try {
            content = Files.readString(filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.unserialize(content);
    }
}
// END
