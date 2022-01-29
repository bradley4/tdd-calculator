package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {
    int plus(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int[] elements = split(input);

        return Arrays
                .stream(elements)
                .sum();
    }

    int[] split(String input) {
        String regex = ",|:";

        if (isCustomRegex(input)) {
            String[] splittingResults = input.split("\\n");
            input = splittingResults[1];
            regex = splittingResults[0].replaceAll("//", "");
        }

        checkException(input, regex);

        String[] inputSplitComma = input.split(regex);
        int[] result =
                Stream.of(inputSplitComma)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        return result;
    }

    boolean isCustomRegex(String input) {
        String regex = "//.+\\n.+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();

    }

    void checkException(String input, String regex) {
        StringBuilder sb = new StringBuilder();
        sb.append(regex);
        sb.append("|0-9");
        String exceptionRegex = sb.toString();

        Pattern pattern = Pattern.compile(exceptionRegex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            throw new RuntimeException("구분자, 숫자 이외의 값(음수 포함)을 포함합니다.");
        }

    }

}
