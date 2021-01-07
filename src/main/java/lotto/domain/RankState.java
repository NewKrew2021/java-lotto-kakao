package lotto.domain;

public enum RankState {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    FAIL(0);

    private int winMoney;

    RankState(int winMoney) {
        this.winMoney = winMoney;
    }

    public int getWinMoney() {
        return winMoney;
    }
}
