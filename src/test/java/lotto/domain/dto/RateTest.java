package lotto.domain.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateTest {
    @Test
    void correctRate() {
        Rate rate = new Rate(100);

        assertThat(rate.getRate()).isEqualTo(100);
    }

    @Test
    void negativeShouldThrowError() {
        assertThatThrownBy(() -> new Rate(-10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testEquals() {
        assertThat(new Rate(100).equals(new Rate(100))).isTrue();
        assertThat(new Rate(100).equals(new Rate(99))).isFalse();
    }
}
