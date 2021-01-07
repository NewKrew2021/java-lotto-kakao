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

}
