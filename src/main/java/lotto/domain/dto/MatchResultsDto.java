package lotto.domain.dto;

import lotto.domain.MatchResult;

import java.util.Map;
import java.util.Objects;

public class MatchResultsDto {
    private final Map<MatchResult, Integer> matchResults;

    public MatchResultsDto(Map<MatchResult, Integer> matchResults) {
        this.matchResults = matchResults;
    }

    public Map<MatchResult, Integer> getMatchResults() {
        return matchResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResultsDto that = (MatchResultsDto) o;
        return Objects.equals(matchResults, that.matchResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResults);
    }
}
