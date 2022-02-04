package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @DisplayName("두 수를 더해서 합을 구한다.")
    @Test
    void plus() {
        //given
        int input1 = 5;
        int input2 = 3;

        //when
        int actual = calculator.plus(input1, input2);

        //then
        assertThat(actual).isEqualTo(8);
    }

    @DisplayName("두 수를 빼서 차를 구한다.")
    @Test
    void minus() {
        //given
        int input1 = 5;
        int input2 = 3;

        //when
        int actual = calculator.minus(input1, input2);

        //then
        assertThat(actual).isEqualTo(2);
    }
}
