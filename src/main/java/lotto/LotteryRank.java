package lotto;

import java.util.HashMap;

public class LotteryRank {
    HashMap<Integer, Integer> lotteryRank;

    public LotteryRank(HashMap<Integer, Integer> ranks) {
        lotteryRank = ranks;
    }

    public int getnthCount(int nthRank) {
        return lotteryRank.getOrDefault(nthRank, 0);
    }
}
