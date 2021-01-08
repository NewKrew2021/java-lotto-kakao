package lotto.util;

public class Prize {
    private static final int FOR_FIRST = 2000000000;
    private static final int FOR_SECOND = 30000000;
    private static final int FOR_THIRD = 1500000;
    private static final int FOR_FOURTH = 50000;
    private static final int FOR_FIFTH = 5000;
    private static final int FOR_NOTHING = 0;

    public static int getPrize(Rank rank) {
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
