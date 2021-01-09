package lotto.domain;


import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return lottoResult.get(rank);
    }

    public long getPrize() {
        return lottoResult.keySet().stream()
                .map(rank -> rank.getPrize() * lottoResult.get(rank))
                .reduce(0L, Long::sum);
    }

    public String getProfitRatio(PurchaseMoney purchaseMoney) {
        return String.format("%.2f", purchaseMoney.getProfitRatio(getPrize()));
    }

}
