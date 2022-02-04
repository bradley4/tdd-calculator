package calculator;

import org.apache.commons.lang3.StringUtils;

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
}
