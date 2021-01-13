package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LotteryRank {

    private final Map<LotteryPrize, Integer> lotteryRank;

    public LotteryRank(Map<LotteryPrize, Integer> ranks) {
        lotteryRank = ranks;
    }

    public int getnthCount(LotteryPrize nthRank) {
        return lotteryRank.getOrDefault(nthRank, 0);
    }

    public long getTotalIncome() {
        long total = 0;
        for (LotteryPrize prize : lotteryRank.keySet()) {
            total += prize.calculateRewardMoney(getnthCount(prize));
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryRank that = (LotteryRank) o;
        return Objects.equals(lotteryRank, that.lotteryRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryRank);
    }
}
