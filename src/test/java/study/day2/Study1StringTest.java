package study.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Study1StringTest {
    Study1String study1String;

    @BeforeEach
    void setUp() {
        study1String = new Study1String();
    }

    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    @Test
    void splitTest() {
        // given
        String testString = "1,2";
        // when
        String[] result = study1String.splitComma(testString);
        String[] expected = new String[]{"1", "2"};
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현")
    @Test
    void splitTestNoDelim() {
        String testString = "1";
        String[] result = study1String.splitComma(testString);
        String[] expected = new String[]{"1"};

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 구현")
    @Test
    void substringTest() {
        String testString = "(1,2)";
        String result = study1String.substringBracket(testString);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현")
    @Test
    void charAtTest() {
        String testString = "abc";
        char result = study1String.charAt(testString, 1);

        assertThat(result).isEqualTo('b');
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
    @Test
    void charAtTestWithException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            String testString = "abc";
            char result = study1String.charAt(testString, 4);
        });
    }

}
