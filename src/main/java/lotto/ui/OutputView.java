package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRank;
import lotto.domain.LotteryUtil;

public class OutputView {
    public static void printLotteries(Lotteries lotteries) {
        System.out.println(lotteries);
        System.out.println();
    }

    public static void printLotteriesRank(LotteryRank lotteryRank) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        for (int i = 0; i < 5; i++) {
            System.out.println(String.format(
                    "%s %d개",
                    LotteryUtil.WINNING_MSG[i],
                    lotteryRank.getnthCount(LotteryUtil.WINNING_TABLE[i][2])));
        }
    }

    public static void printProfitRate(int profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }
}
