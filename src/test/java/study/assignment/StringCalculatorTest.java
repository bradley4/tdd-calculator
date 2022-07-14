package study.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 - \"\" => 0")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void sumStringZerotest(String values) {
        int result = stringCalculator.sumString(values);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 - \"1,2,3,4\" => 10, \"1:2:3:4\" => 10, \"1,2:3,4\" => 10")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1:2:3:4", "1,2:3,4"})
    void sumStringtest(String values) {
        int result = stringCalculator.sumString(values);

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3;4", "//=\n1=2=3=4"})
    void sumStringWithCustomDelimTest(String values) {
        int result = stringCalculator.sumString(values);

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"helloWorld", "-123"})
    void sumStringExceptionTest(String values) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            int result = stringCalculator.sumString(values);
        });
    }

}
