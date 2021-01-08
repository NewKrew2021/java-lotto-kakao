package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoResult {

    private List<Integer> rankCount;
    private double profitRate;

//    public LottoResult( {
//        this.rankCount = new ArrayList<>();
//    }

    //    public List<Integer> getEachCount() {
//        List<Integer> lottoResultEachCount = new ArrayList<>(6);
//        for (RankState rankState : RankState.values()) {
//            lottoResultEachCount.add(lottoResult.stream().filter(result -> result == rankState).count());
//        }
//        return lottoResultEachCount;
//    }
//
//    public int getRevenue() {
//        int revenue = 0;
//        for (RankState rankState : RankState.values()) {
//            revenue += ( * rankState.getWinMoney());
//        }
//        return revenue;
//    }


}
