package study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StringTdd {
    public List<Integer> split(String inputString) {
        String[] splitArr = inputString.split(",");
        List<Integer> arr = new ArrayList();
        for ( String value : splitArr ) {
            arr.add(Integer.parseInt(value));
        }
        return arr;
    }

     public String removeBracket(String inputString) {
        return inputString.substring(1,inputString.length()-1);
    }
}
