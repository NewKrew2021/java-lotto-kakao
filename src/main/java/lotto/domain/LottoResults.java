package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private Map<LottoRank, Integer> results;

    public LottoResults(Map<LottoRank, Integer> lottoResults) {
        this.results = lottoResults;
    }

    public int getCountLottoRank(LottoRank rank){
        if (results.get(rank) != null){
            return results.get(rank);
        }
        return 0;
    }

    public long earningRate(int price) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += getCountLottoRank(rank) * rank.getPrice();
        }
        return (long) (sum / price * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(results, that.results);
    }


}
