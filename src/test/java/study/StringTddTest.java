package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTddTest {

    private StringTdd stringTdd;

    @BeforeEach
    void setUp() {
        stringTdd = new StringTdd();
    }

    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    @Test
    void split() {
        //given
        String inputString = "1,2";
        //when
        List<Integer> strArr = stringTdd.split(inputString);
        //then
        assertThat(strArr).containsExactly(1,2);
    }

    @DisplayName("'1'을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현")
    @Test
    void splitByOne() {
        //given
        String inputString = "1,";
        //when
        List<Integer> strArr = stringTdd.split(inputString);
        //then
        assertAll(
                () -> assertThat(strArr).containsExactly(1),
                () -> assertThat(strArr.size()).isEqualTo(1)
        );
    }

    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 '1,2'를 반환하도록 구현한다")
    @Test
    void removeBracket() {
        //given
        String givenString = "(1,2)";
        //when
        List<Integer> strArr = stringTdd.split(givenString);
        //then
        assertThat(strArr).containsExactly(1,2);
    }
}
