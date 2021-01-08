package lotto;

import java.util.List;
import java.util.Objects;

public class WinningNumberSet {
    private final Lotto winningLotto;
    private final Ball bonusBall;

    public WinningNumberSet(Lotto winningLotto, Ball bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
        if (bonusBall.isDuplicated(winningLotto)) {
            throw new IllegalArgumentException("보너스볼에는 당첨 번호가 포함되어서는 안된다.");
        }
    }

    public Rank compare(List<Ball> balls) {
        int matchedCount = winningLotto.compareWithBalls(balls);
        boolean hasBonus = balls.contains(bonusBall);
        return Rank.createRank(matchedCount, hasBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumberSet that = (WinningNumberSet) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusBall);
    }
}
