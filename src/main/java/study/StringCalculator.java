package study;

public class StringCalculator {
    public int splitStr(String str) {
        String separator = ",|:";

        if (str == null || str.equals("")) return 0;

        if (str.indexOf("//") > -1 && str.indexOf("\n") > -1) {
            separator += "|" + str.substring(str.indexOf("//") + 2, str.indexOf("\n"));
            str = str.replaceAll(str.substring(str.indexOf("//"), str.indexOf("\n") + 1), "");
        }

        return sumArray(str.split(separator));
    }

    public Integer sumArray(String[] strArr) {
        Integer sum = 0;
        for (String s : strArr) {
            Integer i = Integer.parseInt(s);
            if (i < 0) throw new RuntimeException();
            sum += i;
        }
        return sum;
    }
}
