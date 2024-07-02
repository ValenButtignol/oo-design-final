package primenumber;

import output.FileOutputManager;
import primenumber.primenumbergenerators.PrimeNumberGeneratorRecursive;
import primenumber.primenumbergenerators.PrimeNumberGeneratorWithDivisors;

public class Main {
    public static void main(String[] args) {

        PrimeNumberSystem primeNumberSystem = new PrimeNumberSystem(new PrimeNumberGeneratorRecursive(), new FileOutputManager());
        primeNumberSystem.printFirstNPrimeNumbers(8);

        primeNumberSystem.setPrimeNumberGenerator(new PrimeNumberGeneratorWithDivisors());
        primeNumberSystem.printFirstNPrimeNumbers(8);
    }
}