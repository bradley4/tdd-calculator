package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    @Test
    void addNumberBySeparation() {
        //given
        String givenString = "1,2:3:0,:1,2,3";

        //when
        int result = stringCalculator.addNumberBySeparation(givenString);
        //then
        assertThat(result).isEqualTo(12);
    }
}
