package lotto.dto;

import java.util.List;
import java.util.Map;

public class LottoResult {
    final long score;
    final int[] orderCount = new int[10];

    public LottoResult(long score, List<Integer> orderResults){
        this.score = score;
        for (Integer orderResult : orderResults) {
            orderCount[orderResult]++;
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
