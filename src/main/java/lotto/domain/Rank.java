package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0L, 0, "꽝"),
    FIFTH(5_000L, 3, "3개 일치"),
    FOURTH(50_000L, 4, "4개 일치"),
    THIRD(1_500_000L, 5, "5개 일치"),
    SECOND(30_000_000L, 5, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000L, 6, "6개 일치");

    private final long prize;
    private final int matchedCount;
    private final String description;

    Rank(long prize, int matchedCount, String description) {
        this.prize = prize;
        this.matchedCount = matchedCount;
        this.description = description;
    }

    public static Rank createRank(int matchedCount, boolean hasBonus) {
        if (matchedCount == SECOND.matchedCount && hasBonus) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> matchedCount == rank.matchedCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
