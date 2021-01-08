package lotto.domain;

import lotto.domain.dto.Rate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StatisticsResultTest {
    private MatchResults matchResults;
    private StatisticsResult statisticsResult;

    @BeforeEach
    void setUp() {
        matchResults = new MatchResults(Arrays.asList(
                MatchResult.FIRST,
                MatchResult.FOURTH
        ));

        statisticsResult = new StatisticsResult(matchResults, new Rate(100));
    }

    @Test
    void correctEarningRate() {
        assertThat(statisticsResult.getEarningRate()).isEqualTo(100);
    }

    @Test
    void testEquals() {
        MatchResults differentResults = new MatchResults(Arrays.asList(
                MatchResult.FIRST,
                MatchResult.FIFTH
        ));

        assertThat(statisticsResult).isEqualTo(new StatisticsResult(matchResults, new Rate(100)));
        assertThat(statisticsResult).isNotEqualTo(new StatisticsResult(matchResults, new Rate(99)));
        assertThat(statisticsResult).isNotEqualTo(new StatisticsResult(differentResults, new Rate(100)));
    }

    @Test
    void correctCount() {
        assertThat(statisticsResult.getResultCountOfSomeMatch(MatchResult.FIRST)).isEqualTo(1);
        assertThat(statisticsResult.getResultCountOfSomeMatch(MatchResult.SECOND)).isEqualTo(0);
    }
}
