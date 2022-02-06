package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String START_DELIMITER = "//";
    private static final String END_DELIMITER = "\\n";

    public int getSum(String givenString) {
        if (givenString.contains(START_DELIMITER) && givenString.contains(END_DELIMITER)) {
            return getSumByCustomDelimiter(givenString);
        }
        givenString = givenString.replaceAll(COLON,COMMA);
        return addSeparatedNumberByDelimiter(givenString, COMMA);
    }

    private int getSumByCustomDelimiter(String givenString) {

        int startIndex = givenString.indexOf(START_DELIMITER);
        int endIndex = givenString.indexOf(END_DELIMITER);

        String customDelimiter = givenString.substring(startIndex+START_DELIMITER.length(), endIndex);
        String toBeSeperated = givenString.substring(endIndex+END_DELIMITER.length());

        return addSeparatedNumberByDelimiter(toBeSeperated, customDelimiter);
    }

    private int addSeparatedNumberByDelimiter(String givenString, String delimiter) {
        String[] list = givenString.split(Pattern.quote(delimiter));
        int sum = 0;
        for ( String stringNumber : list ) {
            if (StringUtils.isEmpty(stringNumber)){
                continue;
            }
            if (!StringUtils.isNumeric(stringNumber)) {
                throw new RuntimeException();
            }
            sum += Integer.parseInt(stringNumber);
        }
        return sum;
    }
}
