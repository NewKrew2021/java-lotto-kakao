package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000, 6, "6개 일치 "),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, 5, "5개 일치 "),
    FOURTH(50_000, 4, "4개 일치 "),
    FIFTH(5_000, 3, "3개 일치 "),
    NONE(0, 0, "");

    private final int money;
    private final int matchedCount;
    private final String matchedPhrase;

    private final static int NON_GRADE_NUMBER = 3;
    private final static int BONUS_NUMBER_MATCHING_COUNT = 5;

    LottoRank(int money, int matchedCount, String matchedPhrase) {
        this.money = money;
        this.matchedCount = matchedCount;
        this.matchedPhrase = matchedPhrase;
    }

    public int getMoney() {
        return money;
    }

    public static LottoRank checkRanking(int matchNo, int isBonus) {
        if (matchNo < NON_GRADE_NUMBER)
            return LottoRank.NONE;
        if (matchNo == BONUS_NUMBER_MATCHING_COUNT)
            return isBonus==1?SECOND:THIRD;
        if (matchNo < BONUS_NUMBER_MATCHING_COUNT)
            return LottoRank.values()[convertRank(matchNo)];
        return LottoRank.FIRST;
    }


    private static int convertRank(int matchNo) {
        return 7 - matchNo;
    }

    @Override
    public String toString() {
        return matchedPhrase+" ("+money+"원)";
    }
}
