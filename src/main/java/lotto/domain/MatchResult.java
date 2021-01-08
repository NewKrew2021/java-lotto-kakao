package lotto.domain;

public class MatchResult {
    private int count;
    private boolean bonus;

    public MatchResult(int count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        return count * 10 + (bonus && count == 5 ? 1 : 0);
    }
}
