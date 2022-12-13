package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String tagName;
    protected Map <String, String> attributes;

    public Tag(String name, Map <String, String> attributes) {
        this.tagName = name;
        this.attributes = attributes;
    }

    public String toString() {
        String result = "<" + tagName;
        for (var entry : attributes.entrySet()) {
            result += " " + entry.getKey() + "="  + "\"" + entry.getValue() + "\"";
        }
        result += ">";
        return result;
    }

}
// END
