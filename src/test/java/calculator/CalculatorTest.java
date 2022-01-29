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

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 분리된 배열을 리턴한다")
    @Test
    void split_comma_colon_test() {
        // given
        Calculator calculator = new Calculator();
        String input = "1,2";

        // when
        int[] result = calculator.split(input);

        // then
        Assertions.assertThat(result).containsExactly(1,2);
    }
}
