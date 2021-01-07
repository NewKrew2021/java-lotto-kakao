package lotto.domain;

import lotto.domain.LotteryUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LotteryUtilTest {
    @ParameterizedTest
    @CsvSource({"0, 0", "999, 0", "1000, 1", "1001,1", "1999, 1", "2000 , 2"})
    void LotteryUtil_구입가능_로또개수계산(int money, int count) {
        int LotteryCount = LotteryUtil.calculateLotteryCount(money);
        assertThat(LotteryCount).isEqualTo(count);
    }

    @Test
    void LotteryUtil_구입불가능_로또개수계산() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LotteryUtil.calculateLotteryCount(-1));
    }
}