package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;
    public PairedTag (String name, Map <String, String> data, String body, List<Tag> children) {
        super(name, data);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        String result = super.toString();
        for (var ch: children) {
            result +=ch.toString();
        }
        result += body + "</" + tagName + ">";
        return result;
    }
}
// END
