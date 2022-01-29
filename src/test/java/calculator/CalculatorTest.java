package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("빈 값을 전달하면 0을 리턴한다")
    @Test
    void is_blank_test() {
        // given
        Calculator calculator = new Calculator();
        String input = "";

        // when
        int result = calculator.plus(input);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }
}
