package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import output.OutputManager;
import output.TerminalOutputManager;

public class Main {
    public static void main(String[] args) {
        OutputManager outputManager = new TerminalOutputManager();
        PrintFizzBuzz fb = new PrintFizzBuzz(outputManager);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        fb.printFizzBuzz(numbers);
    }
}
