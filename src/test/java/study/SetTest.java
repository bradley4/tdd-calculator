package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void expectNumberSize() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void expectNumberContains(int target) {
        Assertions.assertThat(numbers.contains(target)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void expectTrueOrFalse(int target) {
        Assertions.assertThat(numbers.contains(target)).isTrue();
    }
}
