package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    NOTHING(0, 0, "2개 이하 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final long price;
    private final String message;

    LottoRank(int matchCount, long price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public static LottoRank get(MatchResult result) {
        if(result.getCount() == 5 && result.isBonus()) {
            return SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(value -> value.matchCount == result.getCount())
                .findFirst()
                .orElse(NOTHING);
    }

    public static List<LottoRank> valuesExceptNothing() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NOTHING)
                .collect(Collectors.toList());
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return message + " (" + price + "원)";
    }
}
