package study;

public class StringCalculator {
    final String delimiterOne = ",";
    final String delimiterTwo = ":";
    final String delimiters = "[,:]";

    int add(String input) {
        if (input == null) {
            return 0;
        }
        if (input.contains(delimiterOne) || input.contains(delimiterTwo)) {
            return sumStringArray(dividedWithDelimiters(input));
        } else {
            return sumStringArray(divideWithCustomDelimiters(input));
        }
    }

    private String[] dividedWithDelimiters(String input) {
        return input.split(delimiters);
    }

    private String[] divideWithCustomDelimiters(String input) {
        String customDelimiter = String.valueOf(input.charAt(input.indexOf("\\") - 1));
        String[] splitedString = input.replace("//", "")
                .replace("\\n", "").split(customDelimiter);
        return splitedString;
    }

    private int sumStringArray(String[] strings) throws RuntimeException {
        int result = 0;
        for (String el : strings) {
            if (isEmptyString(el)) continue;
            isNumber(el);
            result += Integer.parseInt(el);
        }
        return result;
    }

    private void isNumber(String input) throws RuntimeException {
        char[] charInput = input.toCharArray();
        if (!Character.isDigit(charInput[0])) {
            throw new RuntimeException("숫자를 확인하세요.");
        }
    }

    private boolean isEmptyString(String input) {
        return input.isEmpty() || input.equals("");
    }
}
