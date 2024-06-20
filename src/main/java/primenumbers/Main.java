package primenumbers;

import primenumbers.outputs.FileOutput;
import primenumbers.primenumbergenerators.PrimeNumberGeneratorRecursive;

public class Main {
    public static void main(String[] args) {

        PrimeNumberSystem primeNumberSystem = new PrimeNumberSystem(new PrimeNumberGeneratorRecursive(), new FileOutput());
        primeNumberSystem.printFirstNPrimeNumbers(8);
    }
}
