package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRank;
import lotto.domain.LotteryUtil;

public class Main {
    public static void main(String[] args) {
        final int lotteryCount = LotteryUtil.calculateLotteryCount(InputView.readMoney());
        OutputView.printLotteryCount(lotteryCount);

        Lotteries lotteries = new Lotteries(Lotteries.getRandomLotteryList(lotteryCount));
        OutputView.printLotteries(lotteries);

        LotteryRank lotteryRank = lotteries.calculateRank(InputView.readLotteryAnswer());
        OutputView.printLotteriesRank(lotteryRank);

        int profit = LotteryUtil.calculateProfitRate(lotteryCount, lotteryRank.getTotalIncome());
        OutputView.printProfitRate(profit);
    }
}
