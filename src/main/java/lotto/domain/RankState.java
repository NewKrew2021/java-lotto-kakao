package lotto.domain;

import java.util.Arrays;

public enum RankState {

    FIRST(2_000_000_000, 5,6),
    SECOND(30_000_000, 4,5),
    THIRD(1_500_000, 3,5),
    FOURTH(50_000, 2,4),
    FIFTH(5_000, 1,3),
    FAIL(0, 0,2);

    private final int winMoney;
    private final int rankIndex;
    private final int matchCount;

    RankState(int winMoney, int rankIndex, int matchCount) {
        this.winMoney = winMoney;
        this.rankIndex = rankIndex;
        this.matchCount = matchCount;
    }

    public static RankState rank(int matchCount, boolean bonusMatched) {
        if (SECOND.isMatchCount(matchCount)) {
            return chooseSecondOrThird(bonusMatched);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElse(FAIL);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private static RankState chooseSecondOrThird(boolean bonusMatched) {
        if (bonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getRankIndex() {
        return rankIndex;
    }
}
