package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    NOTHING(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final long price;

    LottoRank(int matchCount, long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoRank get(int matchCount, boolean isBonus) {
        if(matchCount == 5 && isBonus) {
            return SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(value -> value.matchCount == matchCount)
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
        String sentence = matchCount + "개 일치";
        if(this == LottoRank.SECOND) {
            sentence += ", 보너스 볼 일치";
        }
        sentence += "(" + price + "원)";
        return sentence;
    }
}
