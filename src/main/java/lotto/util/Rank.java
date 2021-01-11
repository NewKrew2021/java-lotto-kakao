package lotto.util;

public enum Rank {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    NOTHING;

    public static Rank of(int winCount, int bonusCount) {
        if (winCount == 6) {
            return Rank.FIRST;
        }
        if (winCount == 5 && bonusCount == 1) {
            return Rank.SECOND;
        }
        if (winCount == 5) {
            return Rank.THIRD;
        }
        if (winCount == 4) {
            return Rank.FOURTH;
        }
        if (winCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.NOTHING;
    }
}
