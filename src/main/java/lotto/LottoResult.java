package lotto;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, false, 2000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1500_000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int reward;

    public static LottoResult getResult(int matchCount, boolean bonusMatch) {
        boolean finalBonusMatch = matchCount == SECOND.matchCount ? bonusMatch : false;

        return Arrays.stream(values())
                .filter(result -> result.matchCount == matchCount && result.bonusMatch == finalBonusMatch)
                .findFirst()
                .orElse(NOTHING);
    }

    LottoResult(int matchCount, boolean bonusMatch, int reward) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        if (matchCount == SECOND.matchCount && bonusMatch)
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", matchCount, reward);
        return String.format("%d개 일치 (%d원)", matchCount, reward);
    }
}
