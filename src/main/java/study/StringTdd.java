package study;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringTdd {
    private static final String DELIMITER = ",";
    private static final Character OPEN_BRACE = '(';
    private static final Character CLOSE_BRACE = ')';

    private static final String WRONG_INPUT = "잘못된 입력입니다.";

    public List<Integer> split(String text) {
        return Arrays.stream(subStrings(text).split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String subStrings(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
        if (hasOpenBrace(text) && hasCloseBrace(text)) {
            text = text.substring(1, text.length() - 1);
        }
        return text;
    }

    private boolean hasCloseBrace(String text) {
        return text.charAt(text.length() - 1) == CLOSE_BRACE;
    }

    private boolean hasOpenBrace(String text) {
        return text.charAt(0) == OPEN_BRACE;
    }
}
