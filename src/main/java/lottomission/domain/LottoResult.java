package lottomission.domain;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    private Map<LotteryWinnings, Integer> rankCount;

    public LottoResult(Map<LotteryWinnings, Integer> rankCount){
        this.rankCount = new TreeMap<>(rankCount);
    }

    public Map<LotteryWinnings, Integer> getRankCount(){
        return this.rankCount;
    }

    public int getSumAllWinningMoney() {
        return rankCount
                .keySet()
                .stream()
                .mapToInt(winning -> winning.getMoney() * rankCount.get(winning))
                .sum();
    }
}
