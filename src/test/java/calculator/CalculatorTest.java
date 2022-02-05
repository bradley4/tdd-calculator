package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @DisplayName("빈 값을 전달하면 0을 리턴한다")
    @ParameterizedTest
    @EmptySource()
    void is_blank_test(String input) {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.plus(input);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }



    @DisplayName("배열의 원소의 합을 리턴한다.")
    @Test
    void plus_test() {
        // given
        Calculator calculator = new Calculator();
        String input = "//;\n1;2";

        // when
        int result = calculator.plus(input);

        // then
        Assertions.assertThat(result).isEqualTo(3);
    }

}
