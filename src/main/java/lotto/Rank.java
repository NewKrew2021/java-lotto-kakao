package lotto;

public enum Rank {
    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000L),
    FOURTH(50000L),
    FIFTH(5000L),
    NOTHING(0L);

    private Long prize;

    Rank(Long prize) {
        this.prize = prize;
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
}
