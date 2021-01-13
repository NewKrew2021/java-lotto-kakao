package lotto.utils;

public enum Result {
    UNDERTHREE(2, 0),
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6,2_000_000_000),
    BONUSFIVE(5, 30_000_000);

    private final int match;
    private final int reward;

    Result(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return reward;
    }
}
