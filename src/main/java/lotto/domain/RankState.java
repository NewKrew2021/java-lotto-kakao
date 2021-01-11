package lotto.domain;

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

    public int getWinMoney() {
        return winMoney;
    }

    public int getRankIndex() {
        return rankIndex;
    }
}
