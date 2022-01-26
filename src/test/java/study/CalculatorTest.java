package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("두 수를 더해서 합을 리턴한다")
    @Test
    void plus() {
        final int givenInput1 = 3;
        final int givenInput2 = 2;

        assertThat(calculator.plus(givenInput1, givenInput2)).isEqualTo(5);
    }

    @DisplayName("두 수를 빼서 차를 리턴한다")
    @Test
    void minus() {
        // given
        final int givenInput1 = 5;
        final int givenInput2 = 3;

        // when
        final int actual = calculator.minus(givenInput1, givenInput2);

        // then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("두 수를 곱해서 곱을 리턴한다.")
    @Test
    void multiply() {
        // given
        final int givenInput1 = 5;
        final int givenInput2 = 3;

        // when
        final int actual = calculator.multiply(givenInput1, givenInput2);

        // then
        assertThat(actual).isEqualTo(15);
    }

    @DisplayName("두 수를 나눠서 나눈 값을 리턴한다.")
    @Test
    void divide() {
        // given
        final int givenInput1 = 4;
        final int givenInput2 = 2;

        // when
        final int actual = calculator.divide(givenInput1, givenInput2);

        // then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("두 수 중 하나를 0으로 나누면 예외를 던진다.")
    @Test
    void divide_with_zero() {
        // given
        final int givenInput1 = 4;
        final int givenInput2 = 0;

        // when
        assertThatThrownBy(() -> calculator.divide(givenInput1, givenInput2))
                .isInstanceOf(ArithmeticException.class);
    }
}
