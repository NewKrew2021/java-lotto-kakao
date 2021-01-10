package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryRankCounterTest {
    LotteryRankCounter counter;

    @BeforeEach
    void initial() {
        counter = new LotteryRankCounter();
    }

    @Test
    void LotteryRankCounter_생성() {
        assertThat(counter).isEqualTo(new LotteryRankCounter());
    }

    @Test
    void LotteryRankCounter_개수_집계() {
        counter.count(LotteryRank.toLotteryRank(0, false));
        counter.count(LotteryRank.toLotteryRank(1, false));
        counter.count(LotteryRank.toLotteryRank(2, false));
        counter.count(LotteryRank.toLotteryRank(3, false));
        counter.count(LotteryRank.toLotteryRank(4, false));
        counter.count(LotteryRank.toLotteryRank(5, false));
        counter.count(LotteryRank.toLotteryRank(6, false));
        counter.count(LotteryRank.toLotteryRank(7, false));

        counter.count(LotteryRank.toLotteryRank(0, true));
        counter.count(LotteryRank.toLotteryRank(1, true));
        counter.count(LotteryRank.toLotteryRank(2, true));
        counter.count(LotteryRank.toLotteryRank(3, true));
        counter.count(LotteryRank.toLotteryRank(4, true));
        counter.count(LotteryRank.toLotteryRank(5, true));
        counter.count(LotteryRank.toLotteryRank(6, true));
        counter.count(LotteryRank.toLotteryRank(7, true));

        assertThat(counter.getRankCount(LotteryRank.RANK1)).isEqualTo(2);
        assertThat(counter.getRankCount(LotteryRank.RANK2)).isEqualTo(1);
        assertThat(counter.getRankCount(LotteryRank.RANK3)).isEqualTo(1);
        assertThat(counter.getRankCount(LotteryRank.RANK4)).isEqualTo(2);
        assertThat(counter.getRankCount(LotteryRank.RANK5)).isEqualTo(2);
        assertThat(counter.getRankCount(LotteryRank.RANK_NONE)).isEqualTo(8);
    }
}