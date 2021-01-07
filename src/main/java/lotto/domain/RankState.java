package lotto.domain;

public enum RankState {

    first(2000000000),
    second(30000000),
    third(1500000),
    fourth(50000),
    fifth(5000),
    fail(0);

    private int winMoney;

    RankState(int winMoney) {
        this.winMoney = winMoney;
    }

    public int getWinMoney() {
        return winMoney;
    }
}
