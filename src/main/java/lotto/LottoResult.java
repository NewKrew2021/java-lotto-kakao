package lotto;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, BonusCondition.DONT_CARE, 2000_000_000),
    SECOND(5, BonusCondition.SHOULD_CONTAIN, 30_000_000),
    THIRD(5, BonusCondition.SHOULD_NOT_CONTAIN, 1500_000),
    FOURTH(4, BonusCondition.DONT_CARE, 50000),
    FIFTH(3, BonusCondition.DONT_CARE, 5000),
    NOTHING(0, BonusCondition.DONT_CARE, 0);

    private final int matchCount;
    private final BonusCondition bonusCondition;
    private final int reward;

    public static LottoResult getResult(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(result -> result.matchCount == matchCount && result.getBonusCondition(bonusMatch))
                .findFirst()
                .orElse(NOTHING);
    }

    LottoResult(int matchCount, BonusCondition bonusCondition, int reward) {
        this.matchCount = matchCount;
        this.bonusCondition = bonusCondition;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public boolean getBonusCondition(boolean bonusMatch) {
        if(bonusCondition == BonusCondition.DONT_CARE) return true;
        if(bonusCondition == BonusCondition.SHOULD_CONTAIN && bonusMatch) return true;
        return false;
    }

    @Override
    public String toString() {
        String bonusString = bonusCondition == BonusCondition.SHOULD_CONTAIN ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%d원)", matchCount, bonusString, reward);
    }

    public enum BonusCondition{
        DONT_CARE, SHOULD_CONTAIN, SHOULD_NOT_CONTAIN
    }
}
