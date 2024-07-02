package template.primenumbers;

import output.TerminalOutputManager;

public class Main {
    public static void main(String[] args) {
        PrimeNumberTemplate primeNumberWithDivisors = new NPrimeWithDivisors(new TerminalOutputManager());
        System.out.println("First 8 prime numbers with a algorithm using divisors");
        primeNumberWithDivisors.printFirstNPrimeNumbers(8);
        
        PrimeNumberTemplate primeNumberRecursive = new NPrimesRecursive(new TerminalOutputManager());
        System.out.println("\n First 8 prime numbers with a recursive algorithm: ");
        primeNumberRecursive.printFirstNPrimeNumbers(8);
    }
}