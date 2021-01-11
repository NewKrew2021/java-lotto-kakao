package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    @DisplayName("Number 클래스 생성 테스트")
    void createNumberTest() {
        Number number = Number.of(1);
        assertThat(number).isEqualTo(Number.of(1));
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

}
