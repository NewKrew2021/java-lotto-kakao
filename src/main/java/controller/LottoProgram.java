package controller;

import domain.Lotto;
import domain.Lottos;
import view.LottoProgramView;

import java.math.BigDecimal;

public class LottoProgram {

    private LottoProgramView lottoProgramView;

    public LottoProgram() {
        lottoProgramView = new LottoProgramView();
    }

    public void start() {
        BigDecimal buyAmount = lottoProgramView.getBuyAmountForUser();
        int buyLottoCount = calculateBuyLottoCount(buyAmount);

        lottoProgramView.printBoughtLottosCount(buyLottoCount);
        Lottos lottos = new Lottos(buyLottoCount);

        lottoProgramView.printLottosNumber(lottos);

        Lotto winningLotto = lottoProgramView.getWinningLotto();
        lottoProgramView.printWinningStatistics(lottos.getLottoStatistics(winningLotto, buyAmount.intValue()));
    }

    public int calculateBuyLottoCount(BigDecimal buyAmount) {
        return buyAmount.divide(new BigDecimal(String.valueOf(Lotto.LOTTO_PRICE))).intValue();
    }
}
