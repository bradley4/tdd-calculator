package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Assignment1 {
    StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("쉼표(,), 콜론(:), 커스텀 구분자로 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "[{index}] : input => {0}, output => {1}")
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6", "//;\\n1;2;3|6"}, delimiter = '|')
    void stringCalculatorTest(String input, int output) {
        assertThat(stringCalculator.add(input)).isEqualTo(output);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,:2,:-1", "1,1,k"})
    void stringCalculatorExceptionThrown() {
        Exception exception = assertThrows(RuntimeException.class, () -> stringCalculator.add("1,:2,:-1"));

        String expectedMessage = "숫자를 확인하세요.";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage.contains(expectedMessage)).isTrue();
    }
}
