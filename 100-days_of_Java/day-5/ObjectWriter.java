import java.io.IOException;
import java.io.Serializable;
import java.io.File;

import utils.JsonWriter;

public class ObjectWriter {
    public static void main(String[] args) {
        // Example usage
        Person person = new Person("John Doe", 30);
        File personFile = new File("person.json");
        String filePath;
        try {
            personFile.createNewFile();
            filePath = personFile.getAbsolutePath();
            JsonWriter.writeObjectToFile(person, filePath);
            System.out.println("Object successfully written to file.");
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}