package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void createNumberTest() {
        Number number = Number.from(1);
        assertThat(number).isEqualTo(Number.from(1));
    }

    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> Number.from(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 잘못되었습니다 : 0");
    }
}
