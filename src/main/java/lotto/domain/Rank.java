package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(1, 2_000_000_000, 6),
    SECOND(2, 30_000_000, 5),
    THIRD(3, 1_500_000, 5),
    FOURTH(4, 50_000, 4),
    FIFTH(5, 5_000, 3),
    BOOM(0, 0, 0);

    private final int rank;
    private final int reward;
    private final int matchCount;

    Rank(int rank, int reward, int matchCount) {
        this.rank = rank;
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Stream<Rank> stream() {
        return Stream.of(Rank.values());
    }

    public static Rank findRank(int count, boolean bonusCount) {
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
