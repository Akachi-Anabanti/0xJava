package shopper.src.main.java.Database;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import shopper.src.main.java.utils.JsonWriter;

public class DB {
    private static void saveObjToFile(Object ObjectClass) {
        String fileName = ObjectClass.getClass().getName();
        File objFile = new File(fileName);
        if (!objFile.exists()) {
            try {
                objFile.createNewFile();
                JsonWriter.writeObjectToFile(ObjectClass, objFile.getAbsolutePath());
            } catch (IOException | IllegalAccessException e) {
                System.out.println("Failed to create " + fileName);
                e.printStackTrace();
            }
        } else {
            try {
                JsonWriter.writeObjectToFile(ObjectClass, fileName);
            } catch (IOException | IllegalAccessException e) {
                System.out.println("Something went wrong, couldn't write to file " + fileName);
                e.printStackTrace();
            }
        }
    }

    public static <K, V> void save(Map<K, V> store) {
        for(V obj: store.values()) {
            saveObjToFile(obj);
        }
        System.out.println("Changes Saved!");
    }

    public void delete() {
        System.out.println("Deleted");
    }
}
