package lotto;

public enum Rank {
    FIRST(2000000000L, "6개 일치"),
    SECOND(30000000L, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000L, "5개 일치"),
    FOURTH(50000L, "4개 일치"),
    FIFTH(5000L, "3개 일치"),
    NOTHING(0L, "꽝");

    private Long prize;
    private String description;

    Rank(Long prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    public static Rank createRank(int matchedCount, boolean hasBonus) {
        if (matchedCount == Lotto.COUNT_OF_NUMBERS) {
            return FIRST;
        }
        if (matchedCount == Lotto.COUNT_OF_NUMBERS - 1 && hasBonus) {
            return SECOND;
        }
        if (matchedCount == Lotto.COUNT_OF_NUMBERS - 1) {
            return THIRD;
        }
        if (matchedCount == Lotto.COUNT_OF_NUMBERS - 2) {
            return FOURTH;
        }
        if (matchedCount == Lotto.COUNT_OF_NUMBERS - 3) {
            return FIFTH;
        }
        return NOTHING;
    }

    public Long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
