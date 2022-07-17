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

    public int sumString(String stringNumbers) {
        if (stringNumbers == null || "".equals(stringNumbers)) {
            return 0;
        }
        if (stringNumbers.contains(LEFT_DELIMITER) && stringNumbers.contains(RIGHT_DELIMITER)) {
            return sumStringWithCustomDelim(stringNumbers);
        }

        stringNumbers = stringNumbers.replaceAll(COLON, COMMA);
        String[] splitStringNumbers = stringNumbers.split(COMMA);
        int result = 0;
        for (String stringNumber : splitStringNumbers) {
            checkStringNumber(stringNumber);
            result += Integer.parseInt(stringNumber);
        }
        return result;
    }

    private int sumStringWithCustomDelim(String stringNumbersWithCustomDelim) {
        String customDelim = findCustomDelim(stringNumbersWithCustomDelim);
        String stringNumbers = findStringNumberWithoutDelim(stringNumbersWithCustomDelim);
        String[] splitStringNumbers = stringNumbers.split(customDelim);
        int result = 0;
        for (String stringNumber : splitStringNumbers) {
            checkStringNumber(stringNumber);
            result += Integer.parseInt(stringNumber);
        }

        return result;
    }

    private String findCustomDelim(String stringNumbersWithDelim) {
        int startIndex = stringNumbersWithDelim.indexOf(LEFT_DELIMITER) + LEFT_DELIMITER.length();
        int endIndex = stringNumbersWithDelim.indexOf(RIGHT_DELIMITER);

        return stringNumbersWithDelim.substring(startIndex, endIndex);
    }

    private String findStringNumberWithoutDelim(String stringNubersWithDelim) {
        int startIndex = stringNubersWithDelim.indexOf(RIGHT_DELIMITER) + RIGHT_DELIMITER.length();

        return stringNubersWithDelim.substring(startIndex);
    }

    private void checkStringNumber(String stringNumber){
        char[] characterNumbers = stringNumber.toCharArray();

        for (char characterNumber : characterNumbers) {
            if (!Character.isDigit(characterNumber)) {
                throw new RuntimeException();
            }
        }
    }

}
