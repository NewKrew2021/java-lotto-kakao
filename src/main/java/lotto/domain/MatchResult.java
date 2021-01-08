package lotto.domain;

public enum MatchResult {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NULL(0, 0);

    private final int matchCount;
    private final int reward;

    MatchResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static MatchResult valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return MatchResult.FIRST;
        }

        if (matchCount == 5 && matchBonus) {
            return MatchResult.SECOND;
        }

        if (matchCount == 5) {
            return MatchResult.THIRD;
        }

        if (matchCount == 4) {
            return MatchResult.FOURTH;
        }

        if (matchCount == 3) {
            return MatchResult.FIFTH;
        }

        return MatchResult.NULL;
    }

    public int getReward(){
        return this.reward;
    }

    public int getMatchCount(){
        return this.matchCount;
    }
}
