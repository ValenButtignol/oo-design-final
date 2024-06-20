package fizzbuzz;

import java.util.List;

import fizzbuzz.output.Output;

public class PrintFizzBuzz {

    Output output;

    public PrintFizzBuzz(Output output) {
        this.output = output;
    }

    public void printFizzBuzz(List<Integer> numbers) {
        List<String> res = FizzBuzzSequence.fizzBuzzSequence(numbers);
        String toPrint = String.join(",", res);
        output.print(toPrint);
    }

}
