package lotto.utils;

public enum Result {
    UNDERTHREE(0),
    THREE(5000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000),
    BONUSFIVE(30_000_000);

    private final int reward;

    Result(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
