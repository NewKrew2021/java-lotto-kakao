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

    public float getRateOfProfitResult(UserMoney userMoney) {
        if(userMoney.isUserMoneyZero()){
            throw new IllegalArgumentException("초기 입력 금액이 0원 이기에 수익률을 계산 할 수 없습니다");
        }
        return (float) getSumAllWinningMoney()/ userMoney.getUserMoney();
    }

    private int getSumAllWinningMoney() {
        return rankCount
                .keySet()
                .stream()
                .mapToInt(winning -> winning.getMoney() * rankCount.get(winning))
                .sum();
    }
}
