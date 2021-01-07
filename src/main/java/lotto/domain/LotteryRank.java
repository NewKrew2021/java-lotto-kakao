package lotto.domain;

import java.util.HashMap;
import java.util.Objects;

public class LotteryRank {
    HashMap<Integer, Integer> lotteryRank;

    public LotteryRank(HashMap<Integer, Integer> ranks) {
        lotteryRank = ranks;
    }

    public int getnthCount(int nthRank) {
        return lotteryRank.getOrDefault(nthRank, 0);
    }

    public long getTotalIncome() {
        long total = 0;
        for (int i = 0; i < LotteryUtil.WINNING_TABLE.length; i++) {
            total += (long) LotteryUtil.WINNING_TABLE[i][1] * getnthCount(LotteryUtil.WINNING_TABLE[i][2]);
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
