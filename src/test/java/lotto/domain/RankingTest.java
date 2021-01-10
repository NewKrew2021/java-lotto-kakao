package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankingTest {
    @Test
    public void testGetRank(){
        assertThat(Ranking.getRank(5, true))
                .isEqualTo(Ranking.SECOND);
    }

    @Test
    public void testGetReward(){
        Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        statistics.put(Ranking.FIRST, 1);
        statistics.put(Ranking.SECOND, 1);
        statistics.put(Ranking.THIRD, 1);
        statistics.put(Ranking.FOURTH, 1);
        statistics.put(Ranking.FIFTH, 1);

        assertThat(Ranking.getReward(statistics)).isEqualTo(2031555000);
    }
}
