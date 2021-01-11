package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    @DisplayName("Number 클래스 생성 테스트")
    void createNumberTest() {
        Number number = Number.of(1);
        assertThat(number).isEqualTo(Number.of(1));
    }

    @Test
    @DisplayName("Number 팩토리 메소드 테스트")
    void numberFactoryTest() {
        Number one = Number.of(1);
        assertThat(one == Number.of(1)).isTrue();
        Number.randomNumbers(6);
        assertThat(one == Number.of(1)).isTrue();
        assertThat(one == Number.of(2)).isFalse();
    }

    @Test
    @DisplayName("예외 숫자 테스트")
    void exceptionTest() {
        assertThatThrownBy(() -> Number.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 잘못되었습니다");
        assertThatThrownBy(() -> Number.of(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 잘못되었습니다");
    }

    @Test
    @DisplayName("compareTo 정렬 테스트")
    void sortNumberTest() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            numbers.add(Number.of(i));
        }
        Collections.sort(numbers);
        assertThat(numbers).isSorted();
    }

}
