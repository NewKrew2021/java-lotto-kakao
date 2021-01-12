package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticCalculator {

    public static List<Integer> getRankCount(List<RankState> eachLottoResult) {
        List<Integer> rankCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        for (RankState rankState : eachLottoResult) {
            int rankIndex = getRankIndex(rankState);
            rankCount.set(rankIndex, rankCount.get(rankIndex) + 1);
        }
        return rankCount;
    }

    private static int getRankIndex(RankState rankState) {
        return rankState.getRankIndex();
    }

    public static double getProfitRate(List<RankState> eachLottoResult, Money firstMoney) {
        return firstMoney.getProfitRate(accumulateEarnedMoney(eachLottoResult));
    }

    private static int accumulateEarnedMoney(List<RankState> eachLottoResult) {
        int earnedMoney = 0;
        for (RankState rankState : eachLottoResult) {
            earnedMoney += rankState.getWinMoney();
        }
        return earnedMoney;
    }
}
