package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryRankTest {
    @Test
    void LotteryRank_유효한등수계산() {
        assertThat(LotteryRank.toLotteryRank(6, true)).isEqualTo(LotteryRank.RANK1);
        assertThat(LotteryRank.toLotteryRank(5, true)).isEqualTo(LotteryRank.RANK2);
        assertThat(LotteryRank.toLotteryRank(4, true)).isEqualTo(LotteryRank.RANK4);
        assertThat(LotteryRank.toLotteryRank(3, true)).isEqualTo(LotteryRank.RANK5);
        assertThat(LotteryRank.toLotteryRank(2, true)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(1, true)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(0, true)).isEqualTo(LotteryRank.RANK_NONE);

        assertThat(LotteryRank.toLotteryRank(6, false)).isEqualTo(LotteryRank.RANK1);
        assertThat(LotteryRank.toLotteryRank(5, false)).isEqualTo(LotteryRank.RANK3);
        assertThat(LotteryRank.toLotteryRank(4, false)).isEqualTo(LotteryRank.RANK4);
        assertThat(LotteryRank.toLotteryRank(3, false)).isEqualTo(LotteryRank.RANK5);
        assertThat(LotteryRank.toLotteryRank(2, false)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(1, false)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(0, false)).isEqualTo(LotteryRank.RANK_NONE);
    }

    @Test
    void LotteryRank_유효하지않은등수계산() {
        assertThat(LotteryRank.toLotteryRank(7, true)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(7, false)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(-1, true)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(-1, false)).isEqualTo(LotteryRank.RANK_NONE);
    }

    @Test
    void LotteryRank_유효한등수변환() {
        assertThat(LotteryRank.toLotteryRank(1)).isEqualTo(LotteryRank.RANK1);
        assertThat(LotteryRank.toLotteryRank(2)).isEqualTo(LotteryRank.RANK2);
        assertThat(LotteryRank.toLotteryRank(3)).isEqualTo(LotteryRank.RANK3);
        assertThat(LotteryRank.toLotteryRank(4)).isEqualTo(LotteryRank.RANK4);
        assertThat(LotteryRank.toLotteryRank(5)).isEqualTo(LotteryRank.RANK5);
    }

    @Test
    void LotteryRank_유효하지않은등수변환() {
        assertThat(LotteryRank.toLotteryRank(-1)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(0)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(6)).isEqualTo(LotteryRank.RANK_NONE);
        assertThat(LotteryRank.toLotteryRank(7)).isEqualTo(LotteryRank.RANK_NONE);
    }

}