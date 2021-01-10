package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankingTest {
    @Test
    public void testGetRank() {
        assertThat(Ranking.getRank(5, true))
                .isEqualTo(Ranking.SECOND);
    }

}
