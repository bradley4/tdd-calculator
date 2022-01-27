package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StringTddTest {
    private StringTdd stringTdd;

    @BeforeEach
    void setUp() {
        stringTdd = new StringTdd();
    }

    @DisplayName("1,2을 , 로 split 했을 때 1과 2로 잘 분리")
    @Test
    void split() {
        // given
        final String givenInput = "1,2";

        // when
        List<Integer> actual = stringTdd.split(givenInput);

        // then
        assertThat(actual).contains(1, 2);
    }

    @DisplayName("1만을 포함하는 배열이 반환되는지")
    @Test
    void split_with_one_element() {
        // given
        final String givenInput = "1";

        // when
        List<Integer> actual = stringTdd.split(givenInput);

        // then
        assertThat(actual).containsExactly(1);
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환")
    @Test
    void split_with_substring() {
        // given
        final String givenInput = "(1,2)";

        // when
        List<Integer> actual = stringTdd.split(givenInput);

        // then
        assertThat(actual).containsExactly(1, 2);
    }

    @DisplayName("문자에 괄호가 있으면 괄호를 제거한다.")
    @Test
    void subString() {
        final String givenText = "(3,4)";

        final String actual = stringTdd.subStrings(givenText);

        assertThat(actual).isEqualTo("3,4");
    }


}
