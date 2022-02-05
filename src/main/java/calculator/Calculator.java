package calculator;

import java.util.List;

import static calculator.TextUtil.split;

class Calculator {
    int plus(String textNumbers) {
        List<Integer> numbers = split(textNumbers);
        return numbers.stream().mapToInt(num -> num).sum();
    }
}
