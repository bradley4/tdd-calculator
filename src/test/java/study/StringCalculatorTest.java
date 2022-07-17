package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 기본 구분자로 하여, 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"=0","1,2=3","1,2,3=6","1,2:3=6"}, delimiter = '=')
    void test1(String str, int expectedSum) {
        assertThat(stringCalculator.splitStr(str)).isEqualTo(expectedSum);
    }

    @DisplayName("기본 구분자 외에 커스텀 구분자를 지정하여 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2:3"})
    void test2(String str) {
        assertThat(stringCalculator.splitStr(str)).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값 또는 음수가 있으면 RuntimeException 예외를 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1,1", "1,a,3"})
    void test3(String str) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            stringCalculator.splitStr(str);
        });
    }
}
