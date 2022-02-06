package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTdd {
    private static final String DELIMITER = ",";
    private static final Character OPEN_BRACE = '(';
    private static final Character CLOSE_BRACE = ')';

    public List<Integer> split(String inputString) {
        inputString = removeBracket(inputString);
        return Arrays.stream(inputString.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String removeBracket(String inputString) {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<inputString.length(); i++) {
            Character curChar = inputString.charAt(i);
            if (curChar != OPEN_BRACE && curChar != CLOSE_BRACE){
                sb.append(curChar);
            }
        }
        return sb.toString();
    }
}
