package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryPrize;
import lotto.domain.LotteryRank;

import java.util.Arrays;

public class OutputView {
    public static void printLotteries(Lotteries lotteries,int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.%n",manualCount,autoCount);
        System.out.println(lotteries);
        System.out.println();
    }

    public static void printLotteriesRank(LotteryRank lotteryRank) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        Arrays.stream(LotteryPrize.values()).
                filter(lotteryPrize -> lotteryPrize != LotteryPrize.NONE).
                forEach(lotteryPrize -> System.out.println(lotteryPrize.makeLotteryPrizeMessage() +
                        lotteryRank.getnthCount(lotteryPrize) + "개"));
    }

    public static void printProfitRate(int profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    public static void printReadMoneyHelp() {
        System.out.println("로또 1장의 가격은 1000원이다.");
        System.out.println("구입금액을 입력해 주세요.");
    }
}
