package lotto.domain;

import java.util.HashMap;
import java.util.Objects;

public class LotteryRankCounter {
    private HashMap<LotteryRank, Integer> counter = new HashMap<>();

    public long getTotalIncome() {
        return counter.entrySet().stream()
                .mapToLong(entry -> entry.getKey().winningPrice * entry.getValue())
                .sum();
    }

    public void count(LotteryRank rank) {
        counter.put(rank, getRankCount(rank) + 1);
    }

    public int getRankCount(LotteryRank rank) {
        return counter.getOrDefault(rank, 0);
    }

    public int getRankCount(int rank) {
        return counter.getOrDefault(LotteryRank.toLotteryRank(rank), 0);
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
