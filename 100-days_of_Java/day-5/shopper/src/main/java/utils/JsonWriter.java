package shopper.src.main.java.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class JsonWriter {

    public static void writeObjectToFile(Object object, String filePath) throws IOException, IllegalAccessException{
        
        String json = convertToJson(object);
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(json);
            writer.write('\n');
        }
    } 

    public static String convertToJson(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        
        Class<?> clazz = object.getClass();
        
        // Traverse the class hierarchy
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(object));
            }
            clazz = clazz.getSuperclass(); // Move up to the parent class
        }

        StringBuilder jsonBuilder = new StringBuilder("{");
        for (Map.Entry<String, Object> entry: map.entrySet()) {
            if (jsonBuilder.length() > 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\"")
            .append(entry.getKey())
            .append("\":\"")
            .append(entry.getValue())
            .append("\"");
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
