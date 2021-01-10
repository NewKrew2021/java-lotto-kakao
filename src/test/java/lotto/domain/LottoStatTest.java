package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStatTest {
    @Test
    public void testGetReward(){
        LottoStat statistics = new LottoStat();
        for (Ranking rank : Ranking.values()) {
            statistics.addValue(rank, 1);
        }

        assertThat(statistics.getReward()).isEqualTo(2031555000);
    }

}
