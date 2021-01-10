package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryRankTest {
    @Test
    void LotteryRank_유효한등수계산() {
        assertThat(LotteryRank.toLotteryRank(6, true).rank).isEqualTo(1);
        assertThat(LotteryRank.toLotteryRank(5, true).rank).isEqualTo(2);
        assertThat(LotteryRank.toLotteryRank(4, true).rank).isEqualTo(4);
        assertThat(LotteryRank.toLotteryRank(3, true).rank).isEqualTo(5);
        assertThat(LotteryRank.toLotteryRank(2, true).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(1, true).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(0, true).rank).isEqualTo(LotteryRank.NONE);

        assertThat(LotteryRank.toLotteryRank(6, false).rank).isEqualTo(1);
        assertThat(LotteryRank.toLotteryRank(5, false).rank).isEqualTo(3);
        assertThat(LotteryRank.toLotteryRank(4, false).rank).isEqualTo(4);
        assertThat(LotteryRank.toLotteryRank(3, false).rank).isEqualTo(5);
        assertThat(LotteryRank.toLotteryRank(2, false).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(1, false).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(0, false).rank).isEqualTo(LotteryRank.NONE);
    }

    @Test
    void LotteryRank_유효하지않은등수계산() {
        assertThat(LotteryRank.toLotteryRank(7, true).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(7, false).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(-1, true).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(-1, false).rank).isEqualTo(LotteryRank.NONE);
    }

    @Test
    void LotteryRank_유효한등수변환() {
        assertThat(LotteryRank.toLotteryRank(1).rank).isEqualTo(1);
        assertThat(LotteryRank.toLotteryRank(2).rank).isEqualTo(2);
        assertThat(LotteryRank.toLotteryRank(3).rank).isEqualTo(3);
        assertThat(LotteryRank.toLotteryRank(4).rank).isEqualTo(4);
        assertThat(LotteryRank.toLotteryRank(5).rank).isEqualTo(5);
    }

    @Test
    void LotteryRank_유효하지않은등수변환() {
        assertThat(LotteryRank.toLotteryRank(-1).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(0).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(6).rank).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.toLotteryRank(7).rank).isEqualTo(LotteryRank.NONE);
    }

}