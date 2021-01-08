package lotto.domain;

import java.util.Arrays;

public enum LotteryPrize {
    
    NONE(0,0,false),
    FIFTH(3,5_000,false),
    FORTH(4,50_000,false),
    THIRD(5,1_500_000,false),
    SECOND(5,30_000_000,true),
    FIRST(6,2_000_000_000,false);

    private final int correctCount;
    private final int rewardMoney;
    private final boolean bonus;

    LotteryPrize(int correctCount, int rewardMoney,boolean bonus) {
        this.correctCount = correctCount;
        this.rewardMoney = rewardMoney;
        this.bonus = bonus;
    }

    public String makeLotteryPrizeMessage(LotteryPrize prize){
        StringBuilder stb = new StringBuilder();
        stb.append(prize.correctCount).append(" 개 일치");
        if(prize.bonus){
            stb.append(", 보너스볼 일치");
        }
        stb.append(" (").append(prize.rewardMoney).append("원) - ");
        return stb.toString();
    }

    public static LotteryPrize findRank(int count, boolean bonus){
        return Arrays.stream(values())
                .filter(lotteryPrize -> lotteryPrize.correctCount == count && lotteryPrize.bonus == bonus)
                .findAny()
                .orElse(NONE);
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

}
