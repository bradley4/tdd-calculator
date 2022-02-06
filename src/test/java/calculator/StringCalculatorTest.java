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

    @DisplayName("앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. ")
    @Test
    void addNumberByCustomSeparation() {
        //given
        String givenString = "//^\\n1^2^3^0^1^2^3";

        //when
        int result = stringCalculator.addNumberByCustomSeparation(givenString);

        //then
        assertThat(result).isEqualTo(12);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    @Test
    void throwExceptionIfNotNumber() {
        //given
        String givenString = "//^\\n1^2^3^0^1^2^3";
    }
}
