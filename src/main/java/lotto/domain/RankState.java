package lotto.domain;

import lotto.exception.IllegalRankStateException;

public enum RankState {

    FIRST(2000000000, 5),
    SECOND(30000000, 4),
    THIRD(1500000, 3),
    FOURTH(50000, 2),
    FIFTH(5000, 1),
    FAIL(0, 0);

    private final int winMoney;
    private final int rankIndex;

    RankState(int winMoney, int rankIndex) {
        this.winMoney = winMoney;
        this.rankIndex = rankIndex;
    }

    public static RankState rank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6)
            return RankState.FIRST;
        if (matchCount == 5 && bonusMatched)
            return RankState.SECOND;
        if (matchCount == 5)
            return RankState.THIRD;
        if (matchCount == 4)
            return RankState.FOURTH;
        if (matchCount == 3)
            return RankState.FIFTH;
        if (matchCount < 3)
            return RankState.FAIL;
        throw new IllegalRankStateException();
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getRankIndex() {
        return rankIndex;
    }
}
