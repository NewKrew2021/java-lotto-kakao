package lotto.domain;

import lotto.domain.dto.InsertPrice;
import lotto.domain.dto.Rate;
import lotto.domain.dto.TotalPrice;

import java.util.NoSuchElementException;

public class LottoStatistics {
    private final MatchResults results;
    private final InsertPrice insertPrice;
    private final TotalPrice totalPrice;

    public LottoStatistics(MatchResults results, InsertPrice insertPrice) {
        this.results = results;
        this.insertPrice = insertPrice;
        this.totalPrice = getTotalPrice(results);
    }

    public StatisticsResult getStatisticsResult() {
        double rateInRealNumber = (double) totalPrice.getTotalPrice() / insertPrice.getPrice();
        Rate rate = new Rate((int) Math.round(rateInRealNumber * 100));
        return new StatisticsResult(results, rate);
    }

    protected TotalPrice getTotalPrice(MatchResults results) {
        long[] total = new long[1];

        results.delegate(resultCounter ->
                total[0] = resultCounter.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
                .sum());

        return new TotalPrice(total[0]);
    }
}
