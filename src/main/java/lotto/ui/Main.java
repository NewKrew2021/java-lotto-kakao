package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRank;
import lotto.domain.Money;

public class Main {
    public static void main(String[] args) {
        OutputView.printReadMoneyHelp();
        int lotteryCount = Money.calculateLotteryCount(InputView.readMoney());
        int manualCount = InputView.readManualLotteryCount();

        Lotteries lotteries = InputView.readManualLotteries(manualCount);
        lotteries.addRandomLotteries(lotteryCount - manualCount);
        OutputView.printLotteries(lotteries, manualCount, lotteryCount - manualCount);

        LotteryRank lotteryRank = lotteries.calculateRank(InputView.readLotteryAnswer());
        OutputView.printLotteriesRank(lotteryRank);

        int profit = Money.calculateProfitRate(lotteryCount, lotteryRank.getTotalIncome());
        OutputView.printProfitRate(profit);
    }
}
