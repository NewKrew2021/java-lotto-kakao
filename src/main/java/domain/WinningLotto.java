package domain;

import java.util.List;

public class WinningLotto {

    private List<Integer> lottoBalls;
    private int bonusBall;

    public WinningLotto(List<Integer> balls, int bonusBall) {
        this.lottoBalls = balls;
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
