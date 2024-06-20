package output;

import java.io.FileWriter;
import java.io.IOException;


public class FileOutputManager implements OutputManager {

    private FileWriter file;
    
    @Override
    public void print(String output) {
        try {
            file = new FileWriter("output.txt");
            file.write(output);
            file.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
}
