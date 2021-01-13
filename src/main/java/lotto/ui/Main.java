package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRank;
import lotto.domain.Money;

public class Main {
    public static void main(String[] args) {
        OutputView.printReadMoneyHelp();
        final int lotteryCount = Money.calculateLotteryCount(InputView.readMoney());
        final int manualLotteriesCount = InputView.readManualLotteryCount();
        final int autoLotteriesCount = lotteryCount - manualLotteriesCount;

        Lotteries lotteries = new Lotteries(InputView.readManualLotteries(manualLotteriesCount));
        lotteries.addRandomLotteries(autoLotteriesCount);
        OutputView.printLotteries(lotteries, manualLotteriesCount, autoLotteriesCount);

        LotteryRank lotteryRank = lotteries.calculateRank(InputView.readLotteryAnswer());
        OutputView.printLotteriesRank(lotteryRank);

        int profit = Money.calculateProfitRate(lotteryCount, lotteryRank.getTotalIncome());
        OutputView.printProfitRate(profit);
    }
}
