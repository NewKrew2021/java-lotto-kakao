package lotto.service;

import lotto.domain.LottoRank;

import java.util.List;

public class LottoReviewService {

    private final int LOTTO_PRICE=1000;

    public double getProfitRatio(List<LottoRank> ranks) {

        double ratio=(double) getProfit(ranks)/(double) (ranks.size() * LOTTO_PRICE);

        return ratio;
    }

    public long getProfit(List<LottoRank> ranks) {

        long totalPrize = 0;
        for (LottoRank rank : ranks) {
            totalPrize += rank.getMoney();
        }
        return totalPrize;
    }




}
