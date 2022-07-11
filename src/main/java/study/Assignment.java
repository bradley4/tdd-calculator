package study;

public class Assignment {

    public int getStringSum(String str) {
        String separator = "[,:]";

        if (str.contains("//")) {
            separator = str.substring(str.indexOf("//") + 2, str.indexOf("\\n"));
        }

        String[] splitStr = str
                .replace("//", "")
                .replace("\\n", "")
                .split(separator);

        return getSum(splitStr);
    }

    public int getSum(String[] arrayStr) {
        int sum = 0;
        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].isEmpty()) {
                arrayStr[i] = "0";
            }
            checkString(arrayStr[i]);
            sum += Integer.parseInt(arrayStr[i]);
        }
        return sum;
    }

    public void checkString(String str) {
        String reg = "^[0-9]+$";
        if (!str.matches(reg)) {
            throw new RuntimeException();
        }
    }
}
