package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTddTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    @Test
    void split_test_0() {
        // given
        CollectionTdd collectionTdd = new CollectionTdd();

        // when
        int result = collectionTdd.size(numbers);

        // then
        Assertions
                .assertThat(result)
                .isEqualTo(3);
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_test_0(int number) {
        // then
        assertTrue(numbers.contains(number));
    }

}
