package lotto.ui;

import lotto.domain.Lotteries;
import lotto.domain.LotteryRank;
import lotto.domain.Money;

public class Main {
    public static void main(String[] args) {
        final int lotteryCount = Money.calculateLotteryCount(InputView.readMoney());

        Lotteries lotteries = new Lotteries(Lotteries.getRandomLotteries(lotteryCount));
        OutputView.printLotteries(lotteries);

        LotteryRank lotteryRank = lotteries.calculateRank(InputView.readLotteryAnswer());
        OutputView.printLotteriesRank(lotteryRank);

        int profit = Money.calculateProfitRate(lotteryCount, lotteryRank.getTotalIncome());
        OutputView.printProfitRate(profit);
    }
}
