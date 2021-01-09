package lotto.domain.ranking;

import java.util.Arrays;

import static lotto.domain.ranking.BonusCondition.*;

public enum LottoRanking {

    RANK_1(6, DONT_CARE, 2_000_000_000L, "6개 일치 (2000000000원)-"),
    RANK_2(5, SHOULD_CONTAIN_BONUS, 30_000_000L, "5개 일치, 보너스 볼 일치(30000000원)-"),
    RANK_3(5, NOT_CONTAIN_BONUS, 1_500_000L, "5개 일치 (1500000원)-"),
    RANK_4(4, DONT_CARE, 50_000L, "4개 일치 (50000원)-"),
    RANK_5(3, DONT_CARE, 5_000L, "3개 일치 (5000원)-"),
    NOTHING(0, DONT_CARE, 0L, "");

    private final int matchNumber;
    private final BonusCondition bonusCondition;
    private final long price;
    private final String context;

    LottoRanking(int matchNumber, BonusCondition bonusCondition, long price, String context) {
        this.matchNumber = matchNumber;
        this.bonusCondition = bonusCondition;
        this.price = price;
        this.context = context;
    }

    public static LottoRanking find(int matchNumber, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoRanking ->
                        (lottoRanking.matchNumber == matchNumber) && lottoRanking.bonusCondition.findConditionOf(bonus)
                )
                .findFirst()
                .orElse(NOTHING);
    }

    public long calculatePriceByMultiply(Long count) {
        return count * price;
    }

    public String getContext() {
        return context;
    }
}
