package lotto.domain;

import lotto.exception.LottoRaffleError;

import java.util.stream.Stream;

public enum Rank {
    FIRST(1, 2_000_000_000, 6, false),
    SECOND(2, 30_000_000, 5, true),
    THIRD(3, 1_500_000, 5, false),
    FOURTH(4, 50_000, 4, false),
    FIFTH(5, 5_000, 3, false),
    BOOM(0, 0, 0, false);

    private final int rank;
    private final int reward;
    private final int matchCount;
    private final boolean bonusMatch;

    Rank(int rank, int reward, int matchCount, boolean bonusMatch) {
        this.rank = rank;
        this.reward = reward;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
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

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public static Stream<Rank> stream() {
        return Stream.of(Rank.values());
    }

    public static Rank findRank(int matchCount, boolean bonusMatch) {
        return Rank.stream()
                .filter(rank -> matchRank(matchCount, bonusMatch, rank))
                .findFirst()
                .orElseThrow(LottoRaffleError::new);
    }

    private static boolean matchRank(int matchCount, boolean bonusMatch, Rank rank) {
        if (matchCount == 5) {
            return rank.getMatchCount() == matchCount && rank.getBonusMatch() == bonusMatch;
        }
        if (matchCount < 3) {
            return rank.getMatchCount() < 3;
        }
        return rank.getMatchCount() == matchCount;
    }

}
