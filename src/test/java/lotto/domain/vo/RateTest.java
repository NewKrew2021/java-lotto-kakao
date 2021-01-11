package lotto.domain.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateTest {
    @Test
    void testGetRate() {
        Rate rate = new Rate(100);
        assertThat(rate.getRate()).isEqualTo(100);
        assertThat(rate.getRate()).isNotEqualTo(99);
    }

    @Test
    void testEquals() {
        assertThat(new Rate(100).equals(new Rate(100))).isTrue();
        assertThat(new Rate(100).equals(new Rate(99))).isFalse();
    }
}
