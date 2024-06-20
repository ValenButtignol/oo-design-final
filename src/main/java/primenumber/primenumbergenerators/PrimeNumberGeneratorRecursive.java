package primenumber.primenumbergenerators;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneratorRecursive implements PrimeNumberGenerator {
    
    public List<Integer> getPrimeNumbers(int number) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber(i, 2)) 
               primeNumbers.add(i);
        }
        return primeNumbers;
    }

    private boolean isPrimeNumber(int number, int i) {
        if (number == 0 || number == 1) 
            return false;

        if (number == i) 
            return true;

        if (number % i == 0)
            return false;
        
        i++;
        
        return isPrimeNumber(number, i);
    }

}
