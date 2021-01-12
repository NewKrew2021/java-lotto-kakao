package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LotteryRank {
    RANK1(2_000_000_000, 6, false, 1),
    RANK2(30_000_000, 5, true, 2),
    RANK3(1_500_000, 5, false, 3),
    RANK4(50_000, 4, false, 4),
    RANK5(5_000, 3, false, 5),
    RANK_NONE(0, 0, false, LotteryRank.NONE);

    private static final int NONE = -1;
    public static final int MIN_RANK = 1;
    public static final int MAX_RANK = 5;

    public final int rank;
    private final int correctCount;
    private final boolean bonusCheck;
    public final long winningPrice;
    public final String winningMsg;

    public static LotteryRank toLotteryRank(int rank) {
        return Arrays.stream(LotteryRank.values())
                .filter(lotteryRank -> lotteryRank.rank == rank)
                .findAny()
                .orElse(RANK_NONE);
    }

    public static LotteryRank toLotteryRank(int count, boolean bonus) {
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
