package lotto;

public enum LottoResult {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    public static final int FIRST_WINNER_MATCH_CONT = 6;
    public static final int SECOND_WINNER_MATCH_COUNT = 5;
    public static final int THIRD_WINNER_MATCH_COUNT = 5;
    public static final int FIFTH_WINNER_MATCH_COUNT = 3;
    public static final int FOURTH_WINNER_MATCH_COUNT = 4;

    private final int matchCount;
    private final boolean bonusMatch;
    private final int reward;

    public static LottoResult getResult(int matchCount, boolean bonusMatch) {
        if (matchCount == FIRST_WINNER_MATCH_CONT) return FIRST;
        if (matchCount == SECOND_WINNER_MATCH_COUNT && bonusMatch) return SECOND;
        if (matchCount == THIRD_WINNER_MATCH_COUNT) return THIRD;
        if (matchCount == FOURTH_WINNER_MATCH_COUNT) return FOURTH;
        if (matchCount == FIFTH_WINNER_MATCH_COUNT) return FIFTH;

        return LottoResult.NOTHING;
    }

    LottoResult(int matchCount, boolean bonusMatch, int reward) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        if (matchCount == SECOND_WINNER_MATCH_COUNT && bonusMatch)
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", matchCount, reward);
        return String.format("%d개 일치 (%d원)", matchCount, reward);
    }
}
