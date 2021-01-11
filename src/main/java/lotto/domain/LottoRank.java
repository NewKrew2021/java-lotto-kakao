package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000, 0, "6개 일치 "), SECOND(30_000_000, 1, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, 2, "5개 일치 "), FOURTH(50_000, 3, "4개 일치 "),
    FIFTH(5_000, 4, "3개 일치 "), NONE(0, 5, "");

    private final int money;
    private final int index;
    private final String matchedPhrase;

    LottoRank(int money, int index, String matchedPhrase) {
        this.money = money;
        this.index = index;
        this.matchedPhrase = matchedPhrase;
    }

    public int getMoney() {
        return money;
    }

    public int getIndex() {
        return index;
    }

    public String getMatchedPhrase() {
        return matchedPhrase;
    }

}
