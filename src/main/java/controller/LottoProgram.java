package controller;

import domain.Lotto;
import domain.LottoStatistics;
import domain.Lottos;
import domain.WinningLotto;
import view.LottoProgramView;

public class LottoProgram {

    private LottoProgramView lottoProgramView;

    public LottoProgram() {
        lottoProgramView = new LottoProgramView();
    }

    public void start() {
        int buyAmount = lottoProgramView.getBuyAmountForUser();
        int buyLottoCount = calculateBuyLottoCount(buyAmount);

        lottoProgramView.printBoughtLottosCount(buyLottoCount);
        Lottos lottos = new Lottos(buyLottoCount);

        lottoProgramView.printLottosNumber(lottos);

        WinningLotto winningLotto = new WinningLotto(lottoProgramView.getWinningLottoForUser()
                , lottoProgramView.getBonusBallForUser());

        LottoStatistics lottoStatistics = new LottoStatistics(lottos.getRankCounts(winningLotto),buyAmount);
        lottoProgramView.printWinningStatistics(lottoStatistics);
    }

    public int calculateBuyLottoCount(int buyAmount) {
        if(buyAmount < 1000){
            throw new IllegalArgumentException("구입 금액이 1000원 이상이어야 합니다.");
        }
        return buyAmount / Lotto.LOTTO_PRICE;
    }
}
