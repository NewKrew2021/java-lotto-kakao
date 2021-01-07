package lotto.domain;

import lotto.domain.LotteryRank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryRankTest {
    @Test
    void LotteryRank_생성() {
        HashMap<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        ranks.put(1, 1);
        assertThat(new LotteryRank(ranks)).isEqualTo(new LotteryRank(ranks));
    }
}