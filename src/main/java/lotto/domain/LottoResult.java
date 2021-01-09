package lotto.domain;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, i -> INITIAL_COUNT));
    }

    public void addRank(Rank rank) {
        lottoResult.put(rank, getRankCount(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return lottoResult.get(rank);
    }

    public long getPrize() {
        return lottoResult.keySet().stream()
                .mapToLong(rank -> rank.getPrize() * lottoResult.get(rank))
                .sum();
    }

    public String getProfitRatio(PurchaseMoney purchaseMoney) {
        return String.format("%.2f", purchaseMoney.getProfitRatio(getPrize()));
    }
}
