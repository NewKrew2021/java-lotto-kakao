package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRank;
import lotto.domain.LotteryRankCounter;

import static lotto.domain.LotteryRank.MAX_RANK;
import static lotto.domain.LotteryRank.MIN_RANK;

public class OutputView {
    public static void printLotteryCount(int count) {
        System.out.printf("%d개를 구매했습니다", count);
        System.out.println();
    }

    public static void printLotteries(Lotteries lotteries) {
        System.out.println(lotteries);
        System.out.println();
    }

    public static void printLotteryResult(LotteryRankCounter lotteryRankCounter) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        for (int i = MIN_RANK; i <= MAX_RANK; i++) {
            LotteryRank rank = LotteryRank.toLotteryRank(i);
            System.out.printf(
                    "%s %d개%n",
                    rank.winningMsg,
                    lotteryRankCounter.getRankCount(rank)
            );
        }
    }

    public static void printProfitRate(int profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }
}
