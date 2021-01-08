package lotto.service;

import lotto.domain.LottoFixedValue;
import lotto.domain.LottoRank;

import java.util.List;

public class LottoReviewService {

    public long getProfit(List<LottoRank> ranks) {

        long totalPrize = 0;
        for (LottoRank rank : ranks) {
            totalPrize += rank.getMoney();
        }
        return totalPrize;
    }

    public int getProfitRatio(List<LottoRank> ranks) {

        return calculateRatio(getProfit(ranks), ranks.size() * LottoFixedValue.LOTTO_PRICE);
    }

    private int calculateRatio(long totalPrize, long totalCost) {
        return (int) Math.round((double) (totalPrize) / (double) (totalCost) * 100);
    }

}
