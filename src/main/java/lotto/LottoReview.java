package lotto;

import java.util.List;

public class LottoReview {

    public long getProfit(List<LottoRank> ranks){

        long totalPrize=0;
        for (LottoRank rank : ranks) {
            totalPrize+=rank.getMoney();
        }
        return totalPrize;
    }

    public int getProfitRatio(List<LottoRank> ranks) {

        return caculateRatio(getProfit(ranks),ranks.size()*1000);
    }

    public int caculateRatio(long totalPrize, long totalCost){

        return Math.round(totalPrize/totalCost)*100;
    }

}
