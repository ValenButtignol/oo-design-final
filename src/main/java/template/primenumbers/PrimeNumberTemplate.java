package template.primenumbers;

import output.OutputManager;
import java.util.List;

public abstract class PrimeNumberTemplate {
    
    private OutputManager outputManager;

    public PrimeNumberTemplate(OutputManager outputManager) {
        this.outputManager = outputManager;
    }

    public abstract List<Integer> getFirstNPrimeNumbers(int n);

    public void printFirstNPrimeNumbers(int n) {
        outputManager.print(getFirstNPrimeNumbers(n).toString());
    }
}