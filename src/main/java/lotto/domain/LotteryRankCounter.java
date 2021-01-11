package lotto.domain;

import java.util.HashMap;
import java.util.Objects;

public class LotteryRankCounter {
    private final HashMap<LotteryRank, Long> counter;

    LotteryRankCounter(HashMap<LotteryRank, Long> rankCounter) {
        this.counter = rankCounter;
    }

    public long getTotalIncome() {
        return counter.entrySet().stream()
                .mapToLong(entry -> entry.getKey().winningPrice * entry.getValue())
                .sum();
    }

    public Long getRankCount(LotteryRank rank) {
        return counter.getOrDefault(rank, 0L);
    }

    public Long getRankCount(int rank) {
        return counter.getOrDefault(LotteryRank.toLotteryRank(rank), 0L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryRankCounter that = (LotteryRankCounter) o;
        return Objects.equals(counter, that.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }
}
