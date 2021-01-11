package lotto.domain;

import lotto.domain.dto.Rate;
import lotto.domain.dto.TotalPrice;

import java.util.Map;

public class LottoStatistics {
    private final MatchResults results;
    private final TotalPrice totalPrice;
    private final int investedMoney;
    private final Rate rate;

    public LottoStatistics(MatchResults results, int investedMoney) {
        this.results = results;
        this.investedMoney = investedMoney;
        this.totalPrice = calcTotalPrice();
        this.rate = calcRate();
    }

    public Map<MatchResult, Integer> getResults() {
        return results.getResult();
    }

    public Rate getEarningRate() {
        return rate;
    }

    private TotalPrice calcTotalPrice() {
        return new TotalPrice(results.getTotalEarnings());
    }

    private Rate calcRate() {
        double rateInRealNumber = (double) totalPrice.getTotalPrice() / investedMoney;
        return new Rate((int) Math.round(rateInRealNumber * 100));
    }
}
