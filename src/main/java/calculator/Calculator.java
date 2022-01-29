package calculator;

import java.util.stream.Stream;

public class Calculator {
    int plus(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        return 0; // 임시 return 문
    }

    int[] split(String input) {
        String regex = ",|:";
        String[] inputSplitComma = input.split(regex);
        int[] result =
                Stream.of(inputSplitComma)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        return result;
    }

}
