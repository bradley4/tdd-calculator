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

    @DisplayName("쉼표(,) 또는 콜론(:)을 제외한 커스텀 구분자를 지정할 수 있다")
    @Test
    void is_custom_separator_test() {
        // given
        Calculator calculator = new Calculator();
        String input = "//;\n1;2";

        // when
        boolean result = calculator.isCustomRegex(input);

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @DisplayName("쉼표(,) 또는 콜론(:) 혹은 커스텀 구분자로 분리된 배열을 리턴한다")
    @Test
    void split_comma_colon_test_contain_custom_separator() {
        // given
        Calculator calculator = new Calculator();
        String input = "//;\n1;2";

        // when
        int[] result = calculator.split(input);

        // then
        Assertions.assertThat(result).containsExactly(1,2);
    }

    @DisplayName("구분자, 숫자 이외의 값(음수 포함)을 전달하는 경우 RuntimeException 발생하는지에 대한 테스트")
    @Test
    void exception_input_test() {
        // given
        Calculator calculator = new Calculator();
        String input = "//;\n1,2";

        // when

        // then
        Assertions.assertThatThrownBy(
                () -> {
                    calculator.split(input);
                }
        )
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("구분자, 숫자 이외의 값(음수 포함)을 포함합니다.");
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
