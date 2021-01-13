package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private HashMap<LottoRank, Integer> result = new HashMap<>();
    private int totalPrice;
    private final int LOTTO_PRICE = 1000;

    public LottoResult(List<LottoRank> lottoRanks) {
        initializationMap();
        for (LottoRank lottoRank : lottoRanks) {
            result.put(lottoRank, result.get(lottoRank) + 1);
        }
        this.totalPrice=lottoRanks.size()*LOTTO_PRICE;
    }

    public void initializationMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }


    public BigDecimal profitRatio() {

        BigDecimal totalPrize = new BigDecimal(String.valueOf(totalPrize()));
        BigDecimal lottoTotalPrice = new BigDecimal(String.valueOf(totalPrice));

        return totalPrize.divide(lottoTotalPrice, 2, BigDecimal.ROUND_HALF_UP);
    }

    private int totalPrize() {
        int sum=0;

        for (LottoRank lottoRank : result.keySet()) {
            sum += result.get(lottoRank) * lottoRank.getMoney();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        for(int i=LottoRank.values().length-2;i>=0;i--){
            sb.append(LottoRank.values()[i].toString());
            sb.append("- ");
            sb.append(result.get(LottoRank.values()[i]));
            sb.append("개\n");
        }
        return sb.toString();
    }


}
