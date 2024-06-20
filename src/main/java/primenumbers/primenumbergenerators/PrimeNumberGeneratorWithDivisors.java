package primenumbers.primenumbergenerators;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneratorWithDivisors implements PrimeNumberGenerator {
    
    public List<Integer> getPrimeNumbers(int number) {
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
