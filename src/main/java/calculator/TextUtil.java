package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextUtil {
    static List<Integer> split(String textNumbers) throws IllegalArgumentException {
        if(textNumbers == null) {
            throw new IllegalArgumentException("Null을 전달해서는 안 됩니다.");
        }
        if (textNumbers.trim().isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        String regex = ",|:";

        if (isCustomRegex(textNumbers)) {
            String[] splittingResults = textNumbers.split("\\n");
            textNumbers = splittingResults[1];
            regex = splittingResults[0].replaceAll("//", "");
        }

        checkException(textNumbers, regex);

        String[] textNumbersSplitComma = textNumbers.split(regex);
        List<Integer> result =
                Arrays.stream(textNumbersSplitComma)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

        return result;
    }

    static boolean isCustomRegex(String textNumbers) {
        String regex = "//.+\\n.+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textNumbers);
        return matcher.find();
    }

    static void checkException(String textNumbers, String regex) {
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
