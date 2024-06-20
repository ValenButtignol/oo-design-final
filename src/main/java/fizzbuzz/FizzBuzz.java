package fizzbuzz;

public class FizzBuzz {
    private static int FIZZ = 3;
    private static int BUZZ = 5;

    public static boolean isFizz(int number) {
        return isDivisible(number, FIZZ) ||
                containsDigit(number, FIZZ);
    }

    public static boolean isBuzz(int number) {
        return isDivisible(number, BUZZ) ||
                containsDigit(number, BUZZ);
    }

    private static boolean isDivisible(int number, int divisor) {
        return number % divisor == 0;
    }

    private static boolean containsDigit(int number, int digit) {
        String numberStr = Integer.toString(number);
        String digitStr = Integer.toString(digit);
        return numberStr.contains(digitStr);
    }
}