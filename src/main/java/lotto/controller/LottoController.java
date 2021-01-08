package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private LottoUI lottoUI;
    private LottoNumberGenerator lottoNumberGenerator;
    private LotteryMachine lotteryMachine;
    private Lottos lottos;
    private Money money;

    public LottoController() {
        lottoUI = new LottoUI();
        lottoNumberGenerator = new RandomNumberGenerator();
    }

    public void buyLotto() {
        money = new Money(lottoUI.getMoneyFromUser());

        List<Lotto> listLottos = new ArrayList<>();
        for (int i = 0; i < money.howMany(); i++) {
            listLottos.add(new Lotto(lottoNumberGenerator));
        }

        lottos = new Lottos(listLottos);
        lottoUI.printLottos(lottos);
    }

    public void getWinningNumber() {
        String winningNumberText = lottoUI.getWinningNumberFromUser();
        int bonusNumber = lottoUI.getBonusNumberFromUser();

        lotteryMachine = new LotteryMachine(winningNumberText, bonusNumber);
    }

    public void matchLotto() {
        Rankings rankings = new Rankings(lottos.raffle(lotteryMachine.getWinningNumber(),lotteryMachine.getBonusNumber()));
        lottoUI.printStatistics(rankings.toString(), rankings.getProfitRate(money));
    }
}
