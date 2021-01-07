package lotto;

import java.util.Arrays;

import static lotto.LottoBonusType.*;

public enum LottoRanking {
    RANK_1(6, DONTCARE, "6개 일치"),
    RANK_2(5, TRUE, "5개 일치, 보너스 볼 일치"),
    RANK_3(5, FALSE, "5개 일치"),
    RANK_4(4, DONTCARE, "4개 일치"),
    RANK_5(3, DONTCARE, "3개 일치"),
    NOTHING(0, DONTCARE, "");

    private final int matchNumber;
    private final LottoBonusType bonusType;
    private final String context;

    LottoRanking(int matchNumber, LottoBonusType bonusType, String context) {
        this.matchNumber = matchNumber;
        this.bonusType = bonusType;
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
}
