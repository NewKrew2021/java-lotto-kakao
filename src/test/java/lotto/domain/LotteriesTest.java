package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {
    Lotteries lotteries;
    List<Lottery> lotteryList;

    @BeforeEach
    void setUp() {
        Lottery lottery1 = new Lottery(new int[]{1, 2, 3, 4, 5, 6});
        Lottery lottery2 = new Lottery(new int[]{7, 8, 9, 10, 11, 12});
        Lottery lottery3 = new Lottery(new int[]{13, 14, 15, 16, 17, 18});

        lotteryList = Arrays.asList(lottery1, lottery2, lottery3);
        lotteries = new Lotteries(lotteryList);
    }

    @Test
    void Lotteries_생성() {
        assertThat(new Lotteries()).isEqualTo(new Lotteries());
        assertThat(lotteries).isEqualTo(new Lotteries(lotteryList));
    }

    @Test
    void Lotteries_등수반환() {
        LotteryRankCounter lotteryRankCounter = lotteries.getLotteryRankCounter(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6}, 10));
        assertThat(lotteryRankCounter.getRankCount(1)).isEqualTo(1);
        assertThat(lotteryRankCounter.getRankCount(2)).isEqualTo(0);
        assertThat(lotteryRankCounter.getRankCount(3)).isEqualTo(0);
        assertThat(lotteryRankCounter.getRankCount(4)).isEqualTo(0);
        assertThat(lotteryRankCounter.getRankCount(5)).isEqualTo(0);
        assertThat(lotteryRankCounter.getRankCount(LotteryRank.RANK_NONE)).isEqualTo(2);
    }
}