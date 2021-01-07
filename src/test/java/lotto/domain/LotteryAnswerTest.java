package lotto.domain;

import lotto.domain.LotteryAnswer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryAnswerTest {
    @Test
    void LotteryAnswer_정상_생성() {
        assertThat(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6}, 7))
                .isEqualTo(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6}, 7));
    }

    @Test
    void LotteryAnswer_보너스번호중복_생성() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6}, 6));
    }

    @Test
    void LotteryAnswer_당첨번호중복_생성() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 5}, 6));
    }

    @Test
    void LotteryAnswer_길이6아닌경우_생성() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryAnswer(new int[]{1, 2, 3, 4, 5}, 6));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6, 7}, 8));

    }

}