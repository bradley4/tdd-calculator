package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void plus_null_또는_빈문자() {
        int result = stringCalculator.plus(null);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.plus("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void plus_숫자하나() {
        int result = stringCalculator.plus("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void plus_쉼표구분자() {
        int result = stringCalculator.plus("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void plus_콜론_구분자() {
        int result = stringCalculator.plus("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void plus_구분자() {
        int result = stringCalculator.plus("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void plus_negative() {
        assertThatThrownBy(() -> stringCalculator.plus("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
