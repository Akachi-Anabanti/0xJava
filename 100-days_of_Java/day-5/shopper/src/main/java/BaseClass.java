package shopper.src.main.java;

import java.util.UUID;

import shopper.src.main.java.utils.JsonWriter;

import java.time.LocalDateTime;
import java.io.File;
import java.io.IOException;


public class BaseClass {
    private final String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseClass() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void save(Object ObjectClass) {
        String fileName = ObjectClass.getClass().getName();
        File objFile = new File(fileName + ".ser");
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
        System.out.println("Saved!");
    }

    public String toJson() {
        try {
            return JsonWriter.convertToJson(this);
        } catch (IllegalAccessException e) {
            System.out.println("Failed to convert to JSON");
            return null;
        }
    }

    public void delete() {
        //TODO: deletes the class
        System.out.println("Deleted");
    }
    public void update() {
        this.updatedAt = LocalDateTime.now();
    }
}
