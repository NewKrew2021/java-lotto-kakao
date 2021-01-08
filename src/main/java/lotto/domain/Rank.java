package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    BOOM(0);

    private final int rank;

    private Rank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static Stream<Rank> stream() {
        return Stream.of(Rank.values());
    }

    public static Rank checkRank(int count, boolean bonusCount) {
        if (count == 6) {
            return Rank.FIRST;
        } else if (count == 5 && bonusCount) {
            return Rank.SECOND;
        } else if (count == 5) {
            return Rank.THIRD;
        } else if (count == 4) {
            return Rank.FOURTH;
        } else if (count == 3) {
            return Rank.FIFTH;
        }
        return Rank.BOOM;
    }

}
