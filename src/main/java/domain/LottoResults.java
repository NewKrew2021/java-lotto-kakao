package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> results;

    public LottoResults() {
        results = new HashMap<LottoRank, Integer>() {{
            Arrays.stream(LottoRank.values())
                    .forEach(rank -> put(rank, 0));
        }};
    }

    public void updateOrInsert(LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return results.get(rank);
    }

    public String result(int price) {
        double sum = Arrays.stream(LottoRank.values())
                .map(rank -> ((double) results.get(rank)) * rank.getPrice())
                .reduce(0.0, Double::sum);
        return this + "총 수익률은 " + (long) ((sum - price) / price * 100) + "%입니다.";
    }

    @Override
    public String toString() {
        return Arrays.stream(LottoRank.values())
                .map(rank -> rank + " - " + results.get(rank) + "개\n")
                .reduce("", (total, rankString) -> total + rankString);
    }
}
