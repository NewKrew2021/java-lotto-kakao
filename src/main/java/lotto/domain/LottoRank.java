package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NOTING(0, "당첨 되지 않음", 0, false),
    FIFTH(5000, "3개 일치", 3, false),
    FOURTH(50000, "4개 일치",4, false),
    THIRD(1500000, "5개 일치",5, false),
    SECOND(30000000, "5개 일치, 보너스 볼 일치",5, true),
    FIRST(2000000000, "6개 일치",6, false);

    private final long price;
    private final String message;
    private final int matchCount;
    private final boolean matchBonusNumber;


    LottoRank(long price, String message, int matchCount, boolean matchBonusNumber) {
        this.price = price;
        this.message = message;
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
    }

    public static LottoRank getRank(int matchCount, boolean bonusNumber){
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonusNumber == bonusNumber)
                .findAny()
                .orElse(NOTING);
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return message + " (" + price + "원)";
    }

}
