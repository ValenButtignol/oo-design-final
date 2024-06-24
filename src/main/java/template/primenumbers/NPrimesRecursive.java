package template.primenumbers;

import output.OutputManager;
import java.util.List;
import java.util.ArrayList;

public class NPrimesRecursive extends PrimeNumberTemplate {

    public NPrimesRecursive(OutputManager outputManager) {
        super(outputManager);
    }

    @Override
    public List<Integer> getFirstNPrimeNumbers(int number) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 0; i <= number; i++) {
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