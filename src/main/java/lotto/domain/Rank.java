package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000),
    BOOM(0, 0);

    private final int rank;
    private final int reward;
    Rank(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
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
