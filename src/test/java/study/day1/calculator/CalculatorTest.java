package study.day1.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    // 각 테스트에서 공통으로 사용할 수 있도록 시작 전 설정
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // TDD 규칙1. 테스트 코드를 보고 어떤 일을 하는지 알 수 있도록 설명을 적어준다.
    @DisplayName("두 수를 입력받아 그 합을 리턴한다.")
    @Test
    void plus() {
        // given - 주어진 환경, 내가 테스트를 할 때 필요한 것
        // when - 실제 테스트
        int result = calculator.plus(1, 2);

        // then - 결과
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("두 수를 입력받아 그 차를 리턴한다.")
    @Test
    void minus() {
        int result = calculator.minus(5, 3);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("두 수를 입력받아 그 곱을 리턴한다.")
    @Test
    void multiply() {
        int result = calculator.multiply(3, 6);

        assertThat(result).isEqualTo(18);
    }
}
