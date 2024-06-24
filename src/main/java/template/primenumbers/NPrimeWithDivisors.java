package template.primenumbers;

import output.OutputManager;
import java.util.List;
import java.util.ArrayList;

public class NPrimeWithDivisors extends PrimeNumberTemplate {

    public NPrimeWithDivisors(OutputManager outputManager) {
        super(outputManager);
    }

    @Override
    public List<Integer> getFirstNPrimeNumbers(int number) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber(i)) 
               primeNumbers.add(i);
        }
        return primeNumbers;
    }

    private boolean isPrimeNumber(int number) {
        return getNumberOfDivisors(number).size() == 2;
    }


    private List<Integer> getNumberOfDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) 
                divisors.add(i);
        }

        return divisors;
    }    
}