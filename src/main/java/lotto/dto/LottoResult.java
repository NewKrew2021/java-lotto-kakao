package lotto.dto;

import lotto.setting.Rank;

import java.util.List;

public class LottoResult {
    final long score;
    final int[] orderCount = new int[10];

    public LottoResult(long score, List<Rank> ranks) {
        this.score = score;
        for (Rank currentRank : ranks) {
            orderCount[currentRank.getValue()]++;
        }
    }

    public long getScore(){
        return score;
    }

    public int getCountOfOrder(int orderNumber){
        return orderCount[orderNumber];
    }

    public double getRate(int inputMoney){
        return (double)score / inputMoney;
    }
}
