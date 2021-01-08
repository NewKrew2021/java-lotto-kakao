package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private Map<LottoRank, Integer> results;

    public LottoResults() {
        results = new HashMap<LottoRank, Integer>() {{
            for (LottoRank rank : LottoRank.values()) {
                put(rank, 0);
            }
        }};
    }

    public void upsert(LottoRank rank) {
        if(isNothing(rank))
            return;
        results.put(rank, results.get(rank) + 1);
    }

    private boolean isNothing(LottoRank rank) {
        return rank == null;
    }

    public int getCount(LottoRank rank) {
        return results.get(rank);
    }

    public double calculateRate(int price) {
        return Math.floor((sumPrizeMoney() / price * 100)) / 100;
    }

    private double sumPrizeMoney() {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += results.get(rank) * rank.getPrice();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            sb.append(rank).append(" - ").append(results.get(rank)).append("개\n");
        }
        return sb.toString();
    }
}
