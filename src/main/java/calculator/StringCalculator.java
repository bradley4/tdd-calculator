package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {

    public int addNumberBySeparation(String givenString) {
        if (givenString.contains("//") && givenString.contains("\\n")) {
            return addNumberByCustomSeparation(givenString);
        }
        givenString = givenString.replaceAll(":",",");
        return getSumByDelimeter(givenString, ",");
    }

    private int addNumberByCustomSeparation(String givenString) {

        int startIndex = givenString.indexOf("//");
        int endIndex = givenString.indexOf("\\n");

        String delimeter = givenString.substring(startIndex+2, endIndex);
        String toBeSeperated = givenString.substring(endIndex+2);

        return getSumByDelimeter(toBeSeperated, delimeter);
    }

    private int getSumByDelimeter(String givenString, String regex) {
        String[] list = givenString.split(Pattern.quote(regex));
        int sum = 0;
        for ( String stringNumber : list ) {
            if (StringUtils.isAlpha(stringNumber)) {
                throw new RuntimeException();
            }

            if (StringUtils.isEmpty(stringNumber))
                continue;

            Integer num = Integer.parseInt(stringNumber);
            if (num < 0) {
                throw new RuntimeException();
            }
            sum += num;
        }
        return sum;
    }
}
