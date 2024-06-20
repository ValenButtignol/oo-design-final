package primenumber;

import output.FileOutputManager;
import primenumber.primenumbergenerators.PrimeNumberGeneratorRecursive;

public class Main {
    public static void main(String[] args) {

        PrimeNumberSystem primeNumberSystem = new PrimeNumberSystem(new PrimeNumberGeneratorRecursive(), new FileOutputManager());
        primeNumberSystem.printFirstNPrimeNumbers(8);
    }
}