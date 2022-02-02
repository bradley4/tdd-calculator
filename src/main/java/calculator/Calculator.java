package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class Calculator {
    int plus(String textNumbers) {
        if (textNumbers.isEmpty()) {
            return 0;
        }
        int[] elements = split(textNumbers);
        return Arrays.stream(elements).sum();
    }

    int[] split(String textNumbers) {
        String regex = ",|:";

        if (isCustomRegex(textNumbers)) {
            String[] splittingResults = textNumbers.split("\\n");
            textNumbers = splittingResults[1];
            regex = splittingResults[0].replaceAll("//", "");
        }

        checkException(textNumbers, regex);

        String[] textNumbersSplitComma = textNumbers.split(regex);
        int[] result =
                Stream.of(textNumbersSplitComma)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        return result;
    }

    boolean isCustomRegex(String textNumbers) {
        String regex = "//.+\\n.+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textNumbers);
        return matcher.find();
    }

    void checkException(String textNumbers, String regex) {
        StringBuilder sb = new StringBuilder();
        sb.append(regex);
        sb.append("|0-9");
        String exceptionRegex = sb.toString();

        Pattern pattern = Pattern.compile(exceptionRegex);
        Matcher matcher = pattern.matcher(textNumbers);

        if (!matcher.find()) {
            throw new RuntimeException("구분자, 숫자 이외의 값(음수 포함)을 포함합니다.");
        }
    }
}
