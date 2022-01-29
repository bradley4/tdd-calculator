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
        Assertions
                .assertThat(result)
                .containsExactly(1, 2);
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
        Assertions
                .assertThat(result)
                .containsExactly(1);
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
        Assertions
                .assertThat(result)
                .containsExactly(1, 2);
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 반환되는지에 대한 테스트")
    @Test
    void charAt_test_0() {
        // given
        StringTdd stringTdd = new StringTdd();
        String input = "abc";
        int index = 1;

        // when
        char result = stringTdd.charAt(input, index);

        // then
        Assertions
                .assertThat(result)
                .isEqualTo('b');
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값(index)을 벗어나면 StringIndexOutOfBoundsException이 발생하는지에 대한 테스트")
    @Test
    void exception_charAt_test() {
        // given
        StringTdd stringTdd = new StringTdd();
        String input = "abc";
        int index = 4;

        // when

        // then
        Assertions.assertThatThrownBy(
                () -> {
                    stringTdd.charAt(input, index);
                }
        )
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index [%d]는 벗어난 인덱스입니다.", index);
    }

}
