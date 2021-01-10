package lotto.domain;

import lotto.domain.dto.Rate;

import java.util.Optional;

public class StatisticsResult {
    private final MatchResults matchResults;
    private final Rate earningRate;

    public StatisticsResult(MatchResults matchResults, Rate earningRate) {
        this.matchResults = matchResults;
        this.earningRate = earningRate;
    }

    public int getResultCountOfSomeMatch(MatchResult matchResult) {
        int[] count = new int[1];

        matchResults.delegate(resultCounter ->
                count[0] = Optional.ofNullable(resultCounter.get(matchResult))
                        .orElse(0));

        return count[0];
    }

    public int getEarningRate() {
        return earningRate.getRate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsResult that = (StatisticsResult) o;
        return matchResults.equals(that.matchResults) && earningRate.equals(that.earningRate);
    }
}
