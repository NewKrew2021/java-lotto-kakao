package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryPrize;
import lotto.domain.LotteryRank;

import java.util.Arrays;

public class OutputView {
    public static void printLotteries(Lotteries lotteries) {
        System.out.println(lotteries);
        System.out.println();
    }

    public static void printLotteriesRank(LotteryRank lotteryRank) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        Arrays.stream(LotteryPrize.values()).
                filter(lotteryPrize -> lotteryPrize != LotteryPrize.NONE).
                forEach(lotteryPrize -> System.out.println(lotteryPrize.makeLotteryPrizeMessage(lotteryPrize) +
                        lotteryRank.getnthCount(lotteryPrize) + "개"));
    }

    public static void printProfitRate(int profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }
}
