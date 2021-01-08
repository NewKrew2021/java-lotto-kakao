package lotto.domain;

public enum LottoReward {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private final int reward;

    private LottoReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }
}
