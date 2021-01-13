package lotto.domain;

import lotto.domain.dto.MatchResultsDto;
import lotto.domain.vo.Price;
import lotto.domain.vo.Rate;

public class LottoStatistics {
    private final MatchResults results;
    private final Price price;
    private final long investedMoney;
    private final Rate rate;

    public LottoStatistics(MatchResults results, long investedMoney) {
        this.results = results;
        this.investedMoney = investedMoney;
        this.price = calcTotalPrice();
        this.rate = calcRate();
    }

    public MatchResultsDto getResults() {
        return results.getResult();
    }

    public Rate getEarningRate() {
        return rate;
    }

    private Price calcTotalPrice() {
        return new Price(results.getTotalEarnings());
    }

    private Rate calcRate() {
        double rateInRealNumber = (double) price.getPrice() / investedMoney;
        return new Rate((int) Math.round(rateInRealNumber * 100));
    }
}
