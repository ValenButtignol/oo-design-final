package adventuregame.displays;

import java.io.FileWriter;
import java.io.IOException;

public class FileDisplayElement extends DisplayElement {

    private String filePath;

    public FileDisplayElement(String filePath) {
        super();
        this.filePath = filePath;
    }

    @Override
    public void display(String str) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}