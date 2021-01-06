package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LotteryNumberTest {
    @Test
    void LotteryNumber_유효하지않은수() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryNumber(0));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryNumber(46));
    }

    @Test
    void LotteryNumber_유효한수() {
        assertThat(new LotteryNumber(1)).isEqualTo(new LotteryNumber(1));
        assertThat(new LotteryNumber(45)).isEqualTo(new LotteryNumber(45));
    }
}