package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryRankTest {
    @Test
    void LotteryRank_생성() {
        HashMap<LotteryPrize, Integer> ranks = new HashMap<>();
        ranks.put(LotteryPrize.FIRST, 1);
        assertThat(new LotteryRank(ranks)).isEqualTo(new LotteryRank(ranks));
    }
}