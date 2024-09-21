package shopper.src.main.java;

import java.util.UUID;

import shopper.src.main.java.utils.JsonWriter;

import java.time.LocalDateTime;


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

    public String toJson() {
        try {
            return JsonWriter.convertToJson(this);
        } catch (IllegalAccessException e) {
            System.out.println("Failed to convert to JSON");
            return null;
        }
    }
    
    public void update() {
        this.updatedAt = LocalDateTime.now();
    }
}
