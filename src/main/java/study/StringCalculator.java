package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int stringToNumberSum(String text) {

        String validatedText = validateText(text);

        String[] splitText = splitString(validatedText);

        if (containsNegativeNumber(splitText)) {
            return Arrays.stream(splitText)
                    .mapToInt(Integer::parseInt)
                    .reduce(0, Integer::sum);
        }

        throw new RuntimeException("입력값에 음수가 포함될수 없습니다.");
    }

    private static String[] splitString(String text) {

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            String group1 = matcher.group(1);
            return matcher.group(2).split(group1);
        }

        return text.split("[,:]");
    }

    private static String validateText(String text) {
        if (text.isEmpty()) {
            return "0";
        }
        return text;
    }

    private static boolean containsNegativeNumber(String[] splitString) {
        return Arrays.stream(splitString)
                .mapToInt(Integer::parseInt)
                .allMatch(number -> number >= 0);
    }
}
