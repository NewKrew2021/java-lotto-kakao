package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000L, "6개 일치", Lotto.COUNT_OF_NUMBERS, false),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치", Lotto.COUNT_OF_NUMBERS - 1, true),
    THIRD(1_500_000L, "5개 일치", Lotto.COUNT_OF_NUMBERS - 1, false),
    FOURTH(50_000L, "4개 일치", Lotto.COUNT_OF_NUMBERS - 2, false),
    FIFTH(5_000L, "3개 일치", Lotto.COUNT_OF_NUMBERS - 3, false),
    NOTHING(0L, "꽝", 0, false);

    private final Long prize;
    private final String description;
    private final int matchedCount;
    private final boolean hasBonus;

    Rank(Long prize, String description, int matchedCount, boolean hasBonus) {
        this.prize = prize;
        this.description = description;
        this.matchedCount = matchedCount;
        this.hasBonus = hasBonus;
    }

    public static Rank createRank(int matchedCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> ((rank.matchedCount == matchedCount) && (!rank.hasBonus || hasBonus)))
                .findFirst()
                .orElse(NOTHING);
    }

    public Long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
