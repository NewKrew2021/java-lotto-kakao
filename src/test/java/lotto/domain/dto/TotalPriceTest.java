package lotto.domain.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TotalPriceTest {
    @Test
    void wonTwoFirstRanks() {
        TotalPrice price = new TotalPrice((long) 4e9);

        assertThat(price.getTotalPrice()).isEqualTo((long) 4e9);
    }

    @Test
    void negativeShouldThrowError() {
        assertThatThrownBy(() -> new TotalPrice(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
