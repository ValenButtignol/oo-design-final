package stringcalculator;

import java.util.List;

public class Calculator {

    public Integer add(List<Integer> numbers) {
        Integer res = 0;
        for (Integer number : numbers) {
            res += number;
        }
        return res;
    }
}