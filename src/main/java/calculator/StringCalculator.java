package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String START_DELIMITER = "//";
    private static final String END_DELIMITER = "\\n";

    public int sum(String textNumbers) {
        if (textNumbers == null) {
            return 0;
        }
        if (textNumbers.contains(START_DELIMITER) && textNumbers.contains(END_DELIMITER)) {
            return getSumByCustomDelimiter(textNumbers);
        }
        textNumbers = textNumbers.replaceAll(COLON,COMMA);
        return addTextNumber(textNumbers, COMMA);
    }

    private int getSumByCustomDelimiter(String textNumbers) {
        String customDelimiter = getCustomDelimiter(textNumbers);
        textNumbers = removeStartAndEndDelimiter(textNumbers);
        return addTextNumber(textNumbers, customDelimiter);
    }

    private String removeStartAndEndDelimiter(String textNumbers) {
        String[] splitByEndDelimiter = separateTextNumbersByDelimiter(textNumbers, END_DELIMITER);
        return splitByEndDelimiter[1];
    }

    private String getCustomDelimiter(String textNumbers) {
        int startIndex = textNumbers.indexOf(START_DELIMITER);
        int endIndex = textNumbers.indexOf(END_DELIMITER);
        String customDelimiter = textNumbers.substring(startIndex+START_DELIMITER.length(), endIndex);
        return customDelimiter;
    }

    private int addTextNumber(String textNumbers, String delimiter) {
        String[] stringNumberArr = separateTextNumbersByDelimiter(textNumbers, delimiter);
        List<String> stringNumberList = Arrays.stream(stringNumberArr)
                                            .filter(stringNumber -> stringNumber != null && stringNumber.length() != 0)
                                            .collect(Collectors.toList());
        int sum = 0;
        for (String stringNumber : stringNumberList) {
            checkNumeric(stringNumber);
            sum += Integer.parseInt(stringNumber);
        }
        return sum;
    }

    private void checkNumeric(String stringNumber){
        Character charNumber = stringNumber.charAt(0);
        if (!Character.isDigit(charNumber)) {
            throw new RuntimeException("숫자 이외의 값 또는 음수는 전달할 수 없습니다.");
        }
    }

    private String[] separateTextNumbersByDelimiter(String textNumbers, String delimiter) {
        Pattern pattern = Pattern.compile("\\"+delimiter);
        return pattern.split(textNumbers);
    }
}
