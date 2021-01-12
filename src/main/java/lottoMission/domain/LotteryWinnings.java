package lottomission.domain;

public enum LotteryWinnings {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    UNRANKED(6, 0, false, 0);

    private final int rank;
    private final int correctNo;
    private final boolean hasBonus;
    private final int money;

    LotteryWinnings(int rank, int correctNo, boolean hasBonus, int money) {
        this.rank = rank;
        this.correctNo = correctNo;
        this.hasBonus = hasBonus;
        this.money = money;
    }

    public static LotteryWinnings getState(int correctNo, boolean hasBonus) {
        if (correctNo == 6) return FIRST;
        if (correctNo == 5 && hasBonus) return SECOND;
        if (correctNo == 5) return THIRD;
        if (correctNo == 4) return FOURTH;
        if (correctNo == 3) return FIFTH;
        return UNRANKED;
    }

    public int getRank() {
        return rank;
    }

    public int getCorrectNo() {
        return correctNo;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    public int getMoney() {
        return money;
    }

}
