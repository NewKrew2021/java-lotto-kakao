package lotto;

import java.util.Arrays;

import static lotto.LottoBonusType.*;

public enum LottoRanking {
    RANK_1(6, DONTCARE, 2_000_000_000L, "6개 일치"),
    RANK_2(5, TRUE, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    RANK_3(5, FALSE, 1_500_000L, "5개 일치"),
    RANK_4(4, DONTCARE, 50_000L, "4개 일치"),
    RANK_5(3, DONTCARE, 5_000L, "3개 일치"),
    NOTHING(0, DONTCARE, 0L, "");

    private final int matchNumber;
    private final LottoBonusType bonusType;
    private final long price;
    private final String context;

    LottoRanking(int matchNumber, LottoBonusType bonusType, long price, String context) {
        this.matchNumber = matchNumber;
        this.bonusType = bonusType;
        this.price = price;
        this.context = context;
    }

    public static LottoRanking find(int matchNumber, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoRanking ->
                        (lottoRanking.matchNumber == matchNumber) && lottoRanking.bonusType.apply(bonus)
                )
                .findFirst()
                .orElse(NOTHING);
    }

    public long earnPrice(Integer value) {
        return value * price;
    }
}
