package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void testCount() {
        assertThat(new Price(1000).count()).isEqualTo(1);
        assertThat(new Price(999).count()).isEqualTo(0);
    }

    @Test
    void testNegative() {
        assertThatThrownBy(() -> new Price(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
