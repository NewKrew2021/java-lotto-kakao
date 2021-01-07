package lotto;

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
        LotteryRank lotteryRank = lotteries.calculateRank(new LotteryAnswer(new int[]{1, 2, 3, 4, 5, 6}, 10));

        assertThat(lotteryRank.getnthCount(1)).isEqualTo(1);
        assertThat(lotteryRank.getnthCount(2)).isEqualTo(0);
        assertThat(lotteryRank.getnthCount(3)).isEqualTo(0);
        assertThat(lotteryRank.getnthCount(4)).isEqualTo(0);
        assertThat(lotteryRank.getnthCount(5)).isEqualTo(0);
        assertThat(lotteryRank.getnthCount(Lottery.NONE)).isEqualTo(2);
    }
}