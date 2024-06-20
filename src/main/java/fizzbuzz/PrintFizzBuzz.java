package fizzbuzz;

import java.util.List;

import output.OutputManager;

public class PrintFizzBuzz {

    OutputManager output;

    public PrintFizzBuzz(OutputManager output) {
        this.output = output;
    }

    public void printFizzBuzz(List<Integer> numbers) {
        List<String> res = FizzBuzzSequence.fizzBuzzSequence(numbers);
        String toPrint = String.join(",", res);
        output.print(toPrint);
    }
}