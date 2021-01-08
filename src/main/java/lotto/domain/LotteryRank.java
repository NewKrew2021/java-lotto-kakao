package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LotteryRank {
    RANK1(2000000000, 6, false, 1),
    RANK2(30000000, 5, true, 2),
    RANK3(1500000, 5, false, 3),
    RANK4(50000, 4, false, 4),
    RANK5(5000, 3, false, 5),
    RANK_NONE(0, 0, false, LotteryRank.NONE);

    public final static int NONE = -1;
    public final static int MIN_RANK = 1;
    public final static int MAX_RANK = 5;

    public final int rank;
    public final int correctCount;
    public final boolean bonusCheck;
    public final long winningPrice;
    public final String winningMsg;

    static public LotteryRank toLotteryRank(int rank) {
        return Arrays.stream(LotteryRank.values())
                .filter(lotteryRank -> lotteryRank.rank == rank)
                .findAny()
                .orElse(RANK_NONE);
    }

    static LotteryRank toLotteryRank(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.correctCount == count)
                .filter(enumValue -> !enumValue.bonusCheck || bonus)
                .max(Comparator.comparingLong(enumValue -> enumValue.winningPrice))
                .orElse(RANK_NONE);
    }

    LotteryRank(int winningPrice, int correctCount, boolean bonusCheck, int rank) {
        this.winningPrice = winningPrice;
        this.correctCount = correctCount;
        this.bonusCheck = bonusCheck;
        this.rank = rank;
        String bonusMsg = "";
        if (bonusCheck) {
            bonusMsg = ", 보너스 볼 일치";
        }
        this.winningMsg = String.format("%d개 일치%s (%d원)-", correctCount, bonusMsg, winningPrice);
    }
}
