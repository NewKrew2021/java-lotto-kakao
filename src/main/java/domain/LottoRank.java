package domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    // 선언 순서 중요
    FIFTH(Arrays.asList(3), Arrays.asList(true, false), new BigDecimal("5000"), "3개 일치 (5000원)- "),
    FOURTH(Arrays.asList(4), Arrays.asList(true, false), new BigDecimal("50000"), "4개 일치 (50000원)- "),
    THIRD(Arrays.asList(5), Arrays.asList(false), new BigDecimal("1500000"), "5개 일치 (1500000원)- "),
    SECOND(Arrays.asList(5), Arrays.asList(true), new BigDecimal("30000000"), "5개 일치, 보너스 볼 일치(30000000원) - "),
    FIRST(Arrays.asList(6), Arrays.asList(true, false), new BigDecimal("2000000000"), "6개 일치 (2000000000원)- ");

    private final List<Integer> rightCounts;
    private final List<Boolean> rightBonusBalls;
    private final BigDecimal reward;
    private final String resultPrefix;

    LottoRank(List<Integer> rightCounts, List<Boolean> rightBonusBalls, BigDecimal reward, String resultPrefix) {
        this.rightCounts = rightCounts;
        this.rightBonusBalls = rightBonusBalls;
        this.reward = reward;
        this.resultPrefix = resultPrefix;
    }

    public boolean checkRank(int count, boolean rightBonusBall) {
        return this.getRightCounts().contains(count) &&
                this.getRightBonusBalls().contains(rightBonusBall);
    }

    public boolean checkRank(Lotto lotto, Lotto winningLotto) {
        return checkRank(lotto.calculateSameBall(winningLotto),
                lotto.hasSameBonusBall(winningLotto));
    }

    private List<Integer> getRightCounts() {
        return rightCounts;
    }

    public List<Boolean> getRightBonusBalls() {
        return rightBonusBalls;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public String getResultPrefix() {
        return resultPrefix;
    }
}
