package mission.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    UNRANKED(0, false, 0);

    private final int correctNo;
    private final boolean hasBonus;
    private final int money;

    Rank(int correctNo, boolean hasBonus, int money) {
        this.correctNo = correctNo;
        this.hasBonus = hasBonus;
        this.money = money;
    }

    public static Rank getRank(int correctNo, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameCorrectNo(correctNo))
                .filter(rank -> !rank.equals(SECOND) || hasBonus)
                .findFirst()
                .orElse(UNRANKED);
    }

    private boolean isSameCorrectNo(int correctNo) {
        return correctNo == this.correctNo;
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
