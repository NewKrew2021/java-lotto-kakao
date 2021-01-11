package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRankCounter;
import lotto.domain.LotteryUtil;

public class Main {
    public static void main(String[] args) {
        final int lotteryCount = LotteryUtil.calculateLotteryCount(InputView.readMoney());
        OutputView.printLotteryCount(lotteryCount);

        Lotteries lotteries = new Lotteries(Lotteries.getRandomLotteryList(lotteryCount));
        OutputView.printLotteries(lotteries);

        LotteryRankCounter lotteryRankCounter = lotteries.getLotteryRankCounter(InputView.readLotteryAnswer());
        OutputView.printLotteryResult(lotteryRankCounter);

        int profit = LotteryUtil.calculateProfitRate(lotteryCount, lotteryRankCounter.getTotalIncome());
        OutputView.printProfitRate(profit);
    }
}
