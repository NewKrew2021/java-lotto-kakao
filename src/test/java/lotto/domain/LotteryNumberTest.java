package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LotteryNumberTest {
    @Test
    void LotteryNumber_유효하지않은수() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LotteryNumber.of(LotteryNumber.MIN_LOTTERYNUMBER - 1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LotteryNumber.of(LotteryNumber.MAX_LOTTERYNUMBER + 1));
    }

    @Test
    void LotteryNumber_유효한수() {
        assertThat(LotteryNumber.of(LotteryNumber.MIN_LOTTERYNUMBER))
                .isEqualTo(LotteryNumber.of(LotteryNumber.MIN_LOTTERYNUMBER));
        assertThat(LotteryNumber.of(LotteryNumber.MAX_LOTTERYNUMBER))
                .isEqualTo(LotteryNumber.of(LotteryNumber.MAX_LOTTERYNUMBER));
    }

    @Test
    void LotteryNumber_동일객체검증() {
        assertThat(LotteryNumber.of(1) == LotteryNumber.of(1)).isTrue();
        assertThat(LotteryNumber.of(45) == LotteryNumber.of(45)).isTrue();
    }
}