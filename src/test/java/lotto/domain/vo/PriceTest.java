package lotto.domain.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void priceSuccessfullyCreatedWithInteger() {
        Price price = new Price((int) 1e9);
        assertThat(price.getPrice()).isEqualTo((long) 1e9);
        assertThat(price.getPrice()).isNotEqualTo((long) 3e9);
    }

    @Test
    void priceSuccessfullyCreated() {
        Price price = new Price((long) 4e9);
        assertThat(price.getPrice()).isEqualTo((long) 4e9);
        assertThat(price.getPrice()).isNotEqualTo((long) 3e9);
    }

    @Test
    void negativeShouldThrowError() {
        assertThatThrownBy(() -> new Price(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
