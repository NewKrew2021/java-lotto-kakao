package lotto.domain;

public enum MatchResult implements EnumMatcher {
    LOSE(0, 0, "꽝!"),
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치") {
        @Override
        public boolean match(int matchCount, boolean matchBonus) {
            return (this.getMatchCount() == matchCount) && !matchBonus;
        }
    },
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치") {
        @Override
        public boolean match(int matchCount, boolean matchBonus) {
            return (this.getMatchCount() == matchCount) && matchBonus;
        }
    },
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
        for (MatchResult result : values()) {
            if (result.match(matchCount, matchBonus)) {
                return result;
            }
        }

        return MatchResult.LOSE;
    }

    public long calculateTotalReward(int rankCount) {
        return (long) this.reward * rankCount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }

    public String getInfo() {
        return this.info;
    }

    @Override
    public boolean match(int matchCount, boolean matchBonus) {
        return this.getMatchCount() == matchCount;
    }
}
