package lotto.domain;

import lotto.domain.dto.MatchResultsDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MatchResults {
    private final Map<MatchResult, Integer> resultCounter;

    public MatchResults(List<MatchResult> results) {
        resultCounter = new EnumMap<>(MatchResult.class);
        for (MatchResult result : results) {
            insertResult(result);
        }
    }

    public MatchResultsDto getResult() {
        return new MatchResultsDto(resultCounter);
    }

    public long getTotalEarnings() {
        return resultCounter.keySet()
                .stream()
                .map(result -> result.calculateTotalReward(resultCounter.get(result)))
                .reduce(0L, Long::sum);
    }

    private void insertResult(MatchResult result) {
        int count = resultCounter.getOrDefault(result, 0);
        resultCounter.put(result, count + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResults that = (MatchResults) o;
        return Objects.equals(resultCounter, that.resultCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCounter);
    }
}
