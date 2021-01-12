package lotto.domain.ranking;

import java.util.Arrays;

import static lotto.domain.ranking.LottoBonusMatcher.*;

public enum LottoRanking {
    RANK_1(6, DONTCARE, 2_000_000_000L, "6개 일치 (2000000000원)-"),
    RANK_2(5, TRUE, 30_000_000L, "5개 일치, 보너스 볼 일치(30000000원)-"),
    RANK_3(5, FALSE, 1_500_000L, "5개 일치 (1500000원)-"),
    RANK_4(4, DONTCARE, 50_000L, "4개 일치 (50000원)-"),
    RANK_5(3, DONTCARE, 5_000L, "3개 일치 (5000원)-"),
    NOTHING(0, DONTCARE, 0L, "");

    private final int matchNumber;
    private final LottoBonusMatcher matchType;
    private final long price;
    private final String context;

    LottoRanking(int matchNumber, LottoBonusMatcher matchType, long price, String context) {
        this.matchNumber = matchNumber;
        this.matchType = matchType;
        this.price = price;
        this.context = context;
    }

    public static LottoRanking find(int matchNumber, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoRanking ->
                        (lottoRanking.matchNumber == matchNumber) && lottoRanking.matchType.calculate(bonus)
                )
                .findFirst()
                .orElse(NOTHING);
    }

    public long earnPrice(Integer value) {
        return value * price;
    }

    public String getContext() {
        return context;
    }

}
