package primenumbers.outputs;

import java.util.List;

public class TerminalOutput implements OutputManager {
    
    @Override
    public void print(List<Integer> primeNumbers) {
        System.out.println("Prime numbers: " + primeNumbers);
    }
}
