package study.assignment;

public class StringCalculator {
    /*
        매직 넘버 : 상수(static final)로 선언하지 않은 숫자
        매직 리터럴 : 상수(static final)로 선언하지 않은 문자열
        숫자나 문자를 선언하지 않고 코드 상에서 그대로 사용하게되면 읽는사람은 그것이 무엇을 의미하는지 알 수 없다.
        상수로 선언하여 이름을 주어 어떤 역할을 하는지 알 수 있게 하자.
     */
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String LEFT_DELIMITER = "//";
    private static final String RIGHT_DELIMITER = "\n";

    public int sumString(String input) {
        if (input == null || "".equals(input)) {
            return 0;
        }
        if (input.contains(LEFT_DELIMITER) && input.contains(RIGHT_DELIMITER)) {
            return sumStringWithCustomDelim(input);
        }

        input = input.replaceAll(COLON, COMMA);
        String[] commaSplitArray = input.split(COMMA);
        int result = 0;
        for (String splitInput : commaSplitArray) {
            checkInput(splitInput);
            result += Integer.parseInt(splitInput);
        }
        return result;
    }

    private int sumStringWithCustomDelim(String input) {
        String customDelim = findCustomDelim(input);
        String inputWithoutDelim = findInput(input);
        String[] commaSplitArray = inputWithoutDelim.split(customDelim);
        int result = 0;
        for (String splitInput : commaSplitArray) {
            checkInput(splitInput);
            result += Integer.parseInt(splitInput);
        }

        return result;
    }

    private String findCustomDelim(String input) {
        int start = input.indexOf(LEFT_DELIMITER) + LEFT_DELIMITER.length();
        int end = input.indexOf(RIGHT_DELIMITER);

        return input.substring(start, end);
    }

    private String findInput(String input) {
        int start = input.indexOf(RIGHT_DELIMITER) + RIGHT_DELIMITER.length();

        return input.substring(start);
    }

    private void checkInput(String splitInput){
        char[] charSplitInputArray = splitInput.toCharArray();

        for (char charSplitInput : charSplitInputArray) {
            if (!Character.isDigit(charSplitInput)) {
                throw new RuntimeException();
            }
        }
    }

}
