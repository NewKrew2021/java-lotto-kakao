package lotto.domain;

public enum MatchResult {
    NULL(0, 0, "꽝!"),
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int reward;
    private final String info;

    MatchResult(int matchCount, int reward, String info) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.info = info;
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

    public int getReward() {
        return this.reward;
    }

    public String getInfo() {
        return this.info;
    }
}
