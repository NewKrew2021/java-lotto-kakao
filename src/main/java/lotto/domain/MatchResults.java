package lotto.domain;

import java.util.*;
import java.util.function.Consumer;

public class MatchResults {
    private Map<MatchResult, Integer> resultCounter;

    public MatchResults(List<MatchResult> results) {
        resultCounter = new EnumMap<>(MatchResult.class);
        for (MatchResult result : results) {
            insertResult(result);
        }
    }

    public void delegate(Consumer<Map<MatchResult, Integer>> consumer) {
        consumer.accept(resultCounter);
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
