package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        String[] arraySymbol = symbols.toLowerCase().split("");
        String[] arrayWord = word.toLowerCase().split("");
        List<String> listSymbol = new ArrayList<>(Arrays.asList(arraySymbol));

        for (String s: arrayWord) {
            if (listSymbol.toString().contains(s)) {
                listSymbol.remove(s);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
