package lotto.util;

public class Prize {
    private static final long FOR_FIRST = 2_000_000_000;
    private static final long FOR_SECOND = 30_000_000;
    private static final long FOR_THIRD = 1_500_000;
    private static final long FOR_FOURTH = 50_000;
    private static final long FOR_FIFTH = 5_000;
    private static final long FOR_NOTHING = 0;

    public static long getPrize(Rank rank) {
        if (rank == Rank.FIRST) {
            return FOR_FIRST;
        }
        if (rank == Rank.SECOND) {
            return FOR_SECOND;
        }
        if (rank == Rank.THIRD) {
            return FOR_THIRD;
        }
        if (rank == Rank.FOURTH) {
            return FOR_FOURTH;
        }
        if (rank == Rank.FIFTH) {
            return FOR_FIFTH;
        }
        return FOR_NOTHING;
    }
}
