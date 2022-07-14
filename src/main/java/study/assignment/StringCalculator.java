package study.assignment;

public class StringCalculator {

    public int sumString(String input) {
        if ("".equals(input)) {
            return 0;
        }
        if (input.contains("//") && input.contains("\n")) {
            return sumStringWithCustomDelim(input);
        }

        input = input.replaceAll(":", ",");
        String[] commaSplitArray = input.split(",");
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
        int start = input.indexOf("//");
        int end = input.indexOf("\n");

        return input.substring(start + 2, end);
    }

    private String findInput(String input) {
        int start = input.indexOf("\n");

        return input.substring(start + 1, input.length());
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
