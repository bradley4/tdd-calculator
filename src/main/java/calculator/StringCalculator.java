package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {

    public int addNumberBySeparation(String givenString) {

        String[] list = givenString.split(",|:");
        int sum = 0;
        for ( String stringNumber : list ) {
            if (StringUtils.isEmpty(stringNumber))
                continue;
            sum += Integer.parseInt(stringNumber);
        }

        return sum;
    }


    public int addNumberByCustomSeparation(String givenString) {

        int startIndex = givenString.indexOf("//");
        int endIndex = givenString.indexOf("\\n");

        String delimeter = givenString.substring(startIndex+2, endIndex);
        String toBeSeperated = givenString.substring(endIndex+2);
        String[] list = toBeSeperated.split(Pattern.quote(delimeter));

        int sum = 0;
        for ( String stringNumber : list ) {
            if (StringUtils.isEmpty(stringNumber))
                continue;
            sum += Integer.parseInt(stringNumber);
        }

        return sum;
    }
}
