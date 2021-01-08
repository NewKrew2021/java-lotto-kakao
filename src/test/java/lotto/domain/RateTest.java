package lotto.domain;

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
}
