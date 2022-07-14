package study.day2;

public class Study1String {

    public String[] splitComma(String input) {
        return input.split(",");
    }

    public String substringBracket(String input) {
        char[] inputArray = input.toCharArray();

        StringBuilder result = new StringBuilder();
        for (char charInput : inputArray) {
            if (charInput != '(' && charInput != ')') {
                result.append(charInput);
            }
        }

        return result.toString();
    }

    public char charAt(String input, int index) {
        return input.charAt(index);
    }

}
