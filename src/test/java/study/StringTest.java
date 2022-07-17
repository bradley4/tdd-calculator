package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("1과 2를 split 으로 분리하기")
    void stringSplit() {
        String targetString = "1,2";

        String[] stringList = targetString.split(",");

        Assertions.assertThat(stringList).containsExactly("1,2");
        Assertions.assertThat(stringList.length).isEqualTo(2);
    }

    @Test
    @DisplayName("subString 메소드 사용하기")
    void stringSubstring() {
        String targetString = "(1,2)";

        int closeIndex = targetString.length() - 1;

        String resultString = targetString.substring(1, closeIndex);

        Assertions.assertThat(resultString).isEqualTo("1,2");
    }

}
