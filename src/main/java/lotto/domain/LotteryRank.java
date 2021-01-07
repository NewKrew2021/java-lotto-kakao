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
