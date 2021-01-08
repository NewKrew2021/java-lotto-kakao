package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LotteryRankTest {
    @Test
    void LotteryRank_생성() {
        HashMap<LotteryPrize, Integer> ranks = new HashMap<>();
        ranks.put(LotteryPrize.FIRST, 1);
        assertThat(new LotteryRank(ranks)).isEqualTo(new LotteryRank(ranks));
    }
}