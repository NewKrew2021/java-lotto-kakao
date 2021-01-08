package lotto.domain;

import lotto.domain.dto.Rate;

public class StatisticsResult {
    private final MatchResults matchResults;
    private final Rate earningRate;

    public StatisticsResult(MatchResults matchResults, Rate earningRate){
        this.matchResults = matchResults;
        this.earningRate = earningRate;
    }

    public MatchResults getMatchResults() {
        return matchResults;
    }

    public Rate getEarningRate() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsResult that = (StatisticsResult) o;
        return matchResults.equals(that.matchResults) && earningRate.equals(that.earningRate);
    }
}
