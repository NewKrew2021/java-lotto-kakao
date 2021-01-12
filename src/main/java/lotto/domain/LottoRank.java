package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000, 0, "6개 일치 "),
    SECOND(30_000_000, 1, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, 2, "5개 일치 "),
    FOURTH(50000, 3, "4개 일치 "),
    FIFTH(5000, 4, "3개 일치 "),
    NONE(0, 5, "");

    private int money;
    private int index;
    private String matchedPhrase;

    private static final int FIRST_PRIZE_MATCHING_COUNT = 6;
    private static final int BONUS_NUMBER_MATCHING_COUNT = 5;
    private static final int NONE_NUMBER_MATCHING_COUNT = 2;

    LottoRank(int money, int index, String matchedPhrase){
        this.money=money;
        this.index = index;
        this.matchedPhrase = matchedPhrase;
    }

    public static LottoRank rankForMatched(int matchNo, boolean isBonusMatched) {
        if (matchNo == FIRST_PRIZE_MATCHING_COUNT)
            return FIRST;

        if(matchNo == BONUS_NUMBER_MATCHING_COUNT)
            return isBonusMatched ? SECOND : THIRD;

        if(matchNo > NONE_NUMBER_MATCHING_COUNT)
            return values()[7-matchNo];

        return NONE;
    }

    public int getMoney(){
        return money;
    }

    public int getIndex(){
        return index;
    }

    public String getMatchedPhrase() { return matchedPhrase; }

}
