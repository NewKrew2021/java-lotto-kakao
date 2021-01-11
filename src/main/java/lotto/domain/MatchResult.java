package lotto.domain;

public class MatchResult {
    private int count;
    private boolean bonus;

    public MatchResult(int count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }
}
