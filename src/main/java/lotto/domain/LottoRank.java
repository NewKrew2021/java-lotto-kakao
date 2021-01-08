package lotto.domain;

public enum LottoRank {
    FIRST(LottoFixedValue.FIRST_PRIZE, 0, "6개 일치 "), SECOND(LottoFixedValue.SECOND_PRIZE, 1, "5개 일치, 보너스 볼 일치"),
    THIRD(LottoFixedValue.THIRD_PRIZE, 2, "5개 일치 "), FOURTH(LottoFixedValue.FOURTH_PRIZE, 3, "4개 일치 "),
    FIFTH(LottoFixedValue.FIFTH_PRIZE, 4, "3개 일치 "), NONE(LottoFixedValue.LOSE_PRIZE, 5, "");

    private int money;
    private int index;
    private String matchedPhrase;

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
