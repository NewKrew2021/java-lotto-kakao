package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatisticCalculator {

    private final List<RankState> eachLottoResult;
    private final Money firstMoney;

    public StatisticCalculator(List<RankState> eachLottoResult, Money firstMoney) {
        this.eachLottoResult = eachLottoResult;
        this.firstMoney = firstMoney;
    }

    public List<Integer> getRankCount() {
        List<Integer> rankCount = new ArrayList<>(6);
        for (RankState rankState : this.eachLottoResult) {
            int rankIndex = getRankIndex(rankState);
            rankCount.set(rankIndex, rankCount.get(rankIndex) + 1);
        }
        return rankCount;
    }

    private int getRankIndex(RankState rankState) {
        return rankState.getRankIndex();
    }

    public double getProfitRate() {
        return firstMoney.getProfitRate(accumulateEarnedMoney());
    }

    private int accumulateEarnedMoney() {
        int earnedMoney = 0;
        for (RankState rankState : eachLottoResult) {
            earnedMoney += rankState.getWinMoney();
        }
        return earnedMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticCalculator that = (StatisticCalculator) o;
        return Objects.equals(eachLottoResult, that.eachLottoResult) && Objects.equals(firstMoney, that.firstMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eachLottoResult, firstMoney);
    }
}
