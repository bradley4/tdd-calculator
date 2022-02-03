package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static calculator.TextUtil.isCustomRegex;
import static calculator.TextUtil.split;

public class TextUtilTest {
    @DisplayName("null 값을 전달하면 NullPointerException을 발생시킨다")
    @Test
    void is_null_test() {
        // given
        String input = null;

        // when

        // then
        Assertions.assertThatThrownBy(() -> split(input))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Null을 전달해서는 안 됩니다.");

    }

    @DisplayName("쉼표(,)와 콜론(:)를 구분자로 분리된 배열을 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2"})
    void split_comma_colon_test(String input) {
        // given

        // when
        List<Integer> result = split(input);

        // then
        Assertions.assertThat(result).containsExactly(1,2);
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 제외한 커스텀 구분자를 지정할 수 있다")
    @Test
    void is_custom_separator_test() {
        // given
        String input = "//;\n1;2";

        // when
        boolean result = isCustomRegex(input);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("쉼표(,) 또는 콜론(:) 혹은 커스텀 구분자로 분리된 배열을 리턴한다")
    @Test
    void split_comma_colon_test_contain_custom_separator() {
        // given
        String input = "//;\n1;2";

        // when
        List<Integer> result = split(input);

        // then
        Assertions.assertThat(result).containsExactly(1,2);
    }

    @DisplayName("구분자, 숫자 이외의 값(음수 포함)을 전달하는 경우 RuntimeException 발생하는지에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1,2", "//;\n-1,-2"})
    void exception_outlier_input_test(String input) {
        // given

        // when

        // then
        Assertions.assertThatThrownBy( () -> split(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("구분자, 숫자 이외의 값(음수 포함)을 포함합니다.");
    }
}
