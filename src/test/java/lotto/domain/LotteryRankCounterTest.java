package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

class LotteryRankCounterTest {

    @Test
    void LotteryRankCounter_생성() {
        HashMap<LotteryRank, Long> hashMap = new HashMap<>();
        LotteryRankCounter counter = new LotteryRankCounter(hashMap);

        assertThat(counter).isEqualTo(new LotteryRankCounter(hashMap));
    }

    @Test
    void LotteryRankCounter_빈입력생성() {
        HashMap<LotteryRank, Long> hashMap = new HashMap<>();
        LotteryRankCounter counter = new LotteryRankCounter(hashMap);

        assertThat(counter.getRankCount(LotteryRank.RANK1)).isEqualTo(0);
        assertThat(counter.getRankCount(LotteryRank.RANK2)).isEqualTo(0);
        assertThat(counter.getRankCount(LotteryRank.RANK3)).isEqualTo(0);
        assertThat(counter.getRankCount(LotteryRank.RANK4)).isEqualTo(0);
        assertThat(counter.getRankCount(LotteryRank.RANK5)).isEqualTo(0);
        assertThat(counter.getRankCount(LotteryRank.RANK_NONE)).isEqualTo(0);
    }

    @Test
    void LotteryRankCounter_유효한입력생성() {
        HashMap<LotteryRank, Long> hashMap = new HashMap<>();
        hashMap.put(LotteryRank.RANK1, 1L);
        hashMap.put(LotteryRank.RANK2, 2L);
        hashMap.put(LotteryRank.RANK3, 3L);
        hashMap.put(LotteryRank.RANK4, 4L);
        hashMap.put(LotteryRank.RANK5, 5L);
        hashMap.put(LotteryRank.RANK_NONE, 6L);
        LotteryRankCounter counter = new LotteryRankCounter(hashMap);

        assertThat(counter.getRankCount(LotteryRank.RANK1)).isEqualTo(1);
        assertThat(counter.getRankCount(LotteryRank.RANK2)).isEqualTo(2);
        assertThat(counter.getRankCount(LotteryRank.RANK3)).isEqualTo(3);
        assertThat(counter.getRankCount(LotteryRank.RANK4)).isEqualTo(4);
        assertThat(counter.getRankCount(LotteryRank.RANK5)).isEqualTo(5);
        assertThat(counter.getRankCount(LotteryRank.RANK_NONE)).isEqualTo(6);
    }
}