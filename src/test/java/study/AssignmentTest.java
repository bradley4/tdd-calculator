package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssignmentTest {

    private Assignment assignment;

    @BeforeEach
    void setUp() {
        assignment = new Assignment();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3"})
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void assignment1(String str) {
        assertThat(assignment.getStringSum(str)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//,\\n1,2,3"})
    @DisplayName("//와 \n 문자열 사이 커스텀 구분자(;)를 기준으로 분리한 각 숫자의 합을 반환")
    void assignment2(String str) {
        assertThat(assignment.getStringSum(str)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#$", "-1"})
    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.")
    void assignment3(String str) {
        assertThatThrownBy(() -> assignment.getStringSum(str)).isInstanceOf(RuntimeException.class);
    }
}
