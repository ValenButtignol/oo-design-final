package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import static fizzbuzz.FizzBuzz.isBuzz;
import static fizzbuzz.FizzBuzz.isFizz;

public class FizzBuzzSequence {

    public static List<String> fizzBuzzSequence(List<Integer> numbers) {
        List<String> res = new ArrayList<>();
        for (Integer elem: numbers) {
            res.add(fizzBuzzString(elem));
        }
        return res;
    }

    private static String fizzBuzzString(Integer elem) {
        if (!isFizz(elem) && !isBuzz(elem))
            return Integer.toString(elem);
        else {
            String temp = "";
            if (isFizz(elem))
                temp += "Fizz";
            if (isBuzz(elem))
                temp += "Buzz";
            return temp;
        }
    }
}