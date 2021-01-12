package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private final String CALCULATE_RATE_ERROR = "수익률 계산에 실패했습니다.";

    private Map<LottoRank, Integer> results;

    public LottoResults() {
        results = new HashMap<LottoRank, Integer>() {{
            for (LottoRank rank : LottoRank.values()) {
                put(rank, 0);
            }
        }};
    }

    public void upsert(LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return results.get(rank);
    }

    public BigDecimal calculateRate(int price) {
        if(price % PurchaseInformation.TICKET_PRICE != 0) {
            throw new IllegalArgumentException(CALCULATE_RATE_ERROR);
        }
        return new BigDecimal(sumPrizeMoney() / price).setScale(2, RoundingMode.FLOOR);
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
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoRank rank : LottoRank.valuesExceptNothing()) {
            stringBuilder.append(rank).append(" - ").append(results.get(rank)).append("개\n");
        }
        return stringBuilder.toString();
    }
}
