package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("두 수를 더해서 합을 리턴한다")
    @Test
    void plus() {
        int input1 = 3;
        int input2 = 2;
        assertThat(calculator.plus(input1, input2)).isEqualTo(5);
    }

    @DisplayName("두 수를 빼서 차를 리턴한다")
    @Test
    void minus() {
        // given
        int input1 = 5;
        int input2 = 3;

        // when
        int actual = calculator.minus(input1, input2);

        // then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("두 수를 빼서 차를 리턴한다")
    @Test
    void divide() {
        // given
        int input1 = 5;
        int input2 = 3;

        // when
        int actual = calculator.minus(input1, input2);

        // then
        assertThat(actual).isEqualTo(2);
    }
}
