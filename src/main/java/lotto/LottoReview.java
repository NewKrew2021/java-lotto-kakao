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

        return calculateRatio(getProfit(ranks),ranks.size()*1000);
    }

    private int calculateRatio(long totalPrize, long totalCost){
        return (int)Math.round((double)(totalPrize)/(double)(totalCost)*100);
    }

}
