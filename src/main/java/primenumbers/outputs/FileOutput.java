package primenumbers.outputs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOutput implements OutputManager {

    private FileWriter file;
    
    @Override
    public void print(List<Integer> output) {
        try {
            file = new FileWriter("firstNPrimeNumbers.txt");
            file.write("Prime numbers: " + output);
            file.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
}
