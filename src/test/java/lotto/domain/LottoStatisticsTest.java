package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStatisticsTest {
    @Test
    public void testGetReward(){
        LottoStatistics statistics = new LottoStatistics();
        for (Ranking rank : Ranking.values()) {
            statistics.addValue(rank, 1);
        }

        assertThat(statistics.getReward()).isEqualTo(2031555000);
    }

}
