package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTddTest {


    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    @Test
    void split_test_0() {
        // given
        StringTdd stringTdd = new StringTdd();
        String input = "1,2";

        // when
        int[] result = stringTdd.split(input);

        // then
        Assertions.assertThat(result).containsExactly(1,2);
    }

    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 테스트")
    @Test
    void split_test_1() {
        // given
        StringTdd stringTdd = new StringTdd();
        String input = "1";

        // when
        int[] result = stringTdd.split(input);

        // then
        Assertions.assertThat(result).containsExactly(1);
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환되는지에 대한 테스트")
    @Test
    void split_test_2() {
        // given
        StringTdd stringTdd = new StringTdd();
        String input = "(1,2)";

        // when
        int[] result = stringTdd.split(input);

        // then
        Assertions.assertThat(result).containsExactly(1,2);
    }

}
