package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
// BEGIN
class Validator {
    public static List<String> validate(Address adr) {
        List<String> defectiveFields = new ArrayList<>();
        Field[] fields = adr.getClass().getDeclaredFields();

        for (Field field : fields) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            try {
                field.setAccessible(true);
                if (notNull != null && field.get(adr) == null) {
                    defectiveFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return defectiveFields;
    }

    public static Map<String, List<String>> advancedValidate(Address adr) throws IllegalAccessException {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : adr.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
            field.setAccessible(true);

            if (notNull != null && field.get(adr) == null) {
                result.put(field.getName(), List.of("can't be null"));
            }
            if (minLength != null) {
                String temp = (String) field.get(adr);
                if (temp.length() < minLength.minLength()) {
                    result.put(field.getName(), List.of("length less than " + minLength.minLength()));
                }
            }
        }
        return result;
    }
}
// END
