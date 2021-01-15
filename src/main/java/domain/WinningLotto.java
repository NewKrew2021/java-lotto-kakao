package domain;

import java.util.List;

public class WinningLotto {

    private List<Ball> lottoBalls;
    private Ball bonusBall;

    public WinningLotto(List<Ball> balls, int bonusNumber) {
        this.lottoBalls = balls;
        Ball bonusBall = new Ball(bonusNumber);

        if (lottoBalls.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼과 로또와 겹치면 안됩니다.");
        }
        this.bonusBall = bonusBall;
    }

    public int calculateSameBall(Lotto lotto) {
        return (int) lottoBalls.stream()
                .filter(lotto::hasBall)
                .count();
    }

    public boolean hasSameBonusBall(Lotto lotto) {
        return lotto.contains(bonusBall);
    }
}
