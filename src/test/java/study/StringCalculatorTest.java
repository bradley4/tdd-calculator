package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("입력값이 빈 값일 경우 0을 반환")
    void input_empty_is_return_zero() {
        int resultNumber = StringCalculator.stringToNumberSum("");

        assertThat(resultNumber).isEqualTo(0);
    }

    @Test
    @DisplayName("입력값이 숫자 하나의 문자열일 경우 해당 숫자를 반환")
    void input_one_number_is_return_this() {
        int resultNumber = StringCalculator.stringToNumberSum("3");

        assertThat(resultNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("입력값을 구분자(,)로 나누고 각 숫자를 합산하여 반환")
    void split_string_with_comma_return_sum() {
        int resultNumber = StringCalculator.stringToNumberSum("1,2,3");

        assertThat(resultNumber).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값을 구분자(,|:)로 나누고 각 숫자를 합산하여 반환")
    void split_string_with_comma_and_colon_return_sum() {
        int resultNumber = StringCalculator.stringToNumberSum("1,2:3");

        assertThat(resultNumber).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값에 포함되어있는 커스텀 구분자를 이용하여 결과 반환")
    void custom_split_return_sum() {
        int resultNumber = StringCalculator.stringToNumberSum("//;\n1;2;3");

        assertThat(resultNumber).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값에 숫자 이외의 값 혹은 음수가 포함되어있으면 RunTimeException 발생")
    void input_negative_return_exception() {
        assertThatThrownBy(() -> StringCalculator.stringToNumberSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
