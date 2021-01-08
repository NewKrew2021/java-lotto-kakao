package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryTest {
    Lottery playerLottery;
    final int[] playerNumbers = {1, 2, 3, 4, 5, 6};

    @BeforeEach
    void setUp() {
        playerLottery = new Lottery(playerNumbers);
    }

    @Test
    void Lottery_자동_생성() {
        Lottery randomLottery = Lottery.createRandomLottery();
        assertThat(randomLottery).isEqualTo(randomLottery);
    }

    @Test
    void Lottery_수동_정상생성() {
        assertThat(new Lottery(playerNumbers)).isEqualTo(new Lottery(playerNumbers));
    }

    @Test
    void Lottery_수동_유효하지않은수범위() {
        /*  LotteryNumberTest 에서 유효하지 않은 수 범위에 대해 테스트가 진행되기에 여기서는 공백 */
    }

    @Test
    void Lottery_당첨번호_보너스숫자_중복() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> playerLottery.checkRank(new LotteryAnswer(playerNumbers, 6)));
    }

    @Test
    void Lottery_수동_번호중복() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lottery(new int[]{1, 2, 3, 4, 4, 5}));
    }

    @Test
    void Lottery_수동_6개가아닌경우() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lottery(new int[]{1, 2, 3, 4, 5}));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lottery(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    void Lottery_당첨_3개일치_5등() {
        LotteryPrize rank = playerLottery.checkRank(new LotteryAnswer(new int[]{1, 2, 3, 9, 10, 11}, 12));
        assertThat(rank).isEqualTo(LotteryPrize.FIFTH);
    }

    @Test
    void Lottery_당첨_4개일치_4등() {
        LotteryPrize rank = playerLottery.checkRank(new LotteryAnswer(new int[]{1, 2, 3, 4, 7, 8}, 10));
        assertThat(rank).isEqualTo(LotteryPrize.FORTH);
    }

    @Test
    void Lottery_당첨_5개일치_3등() {
        LotteryPrize rank = playerLottery.checkRank(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 7}, 10));
        assertThat(rank).isEqualTo(LotteryPrize.THIRD);
    }

    @Test
    void Lottery_당첨_5개_보너스일치_2등() {
        LotteryPrize rank = playerLottery.checkRank(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 7}, 6));
        assertThat(rank).isEqualTo(LotteryPrize.SECOND);
    }

    @Test
    void Lottery_당첨_6개일치_1등() {
        LotteryPrize rank = playerLottery.checkRank(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6}, 7));
        assertThat(rank).isEqualTo(LotteryPrize.FIRST);
    }
}
