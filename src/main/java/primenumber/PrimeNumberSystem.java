package primenumber;

import java.util.List;

import output.OutputManager;
import primenumber.primenumbergenerators.PrimeNumberGenerator;

public class PrimeNumberSystem {
    
    private PrimeNumberGenerator primeNumberGenerator;
    private OutputManager outputManager;

    public PrimeNumberSystem(PrimeNumberGenerator primeNumberGenerator, OutputManager outputManager) {
        this.primeNumberGenerator = primeNumberGenerator;
        this.outputManager = outputManager;
    }

    public List<Integer> printFirstNPrimeNumbers(int number) {
        List<Integer> primeNumbers = primeNumberGenerator.getPrimeNumbers(number);
        outputManager.print(primeNumbers.toString());

        return primeNumbers;
    }
}
