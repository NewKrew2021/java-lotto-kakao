package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottosDto;
import lotto.dto.RankingsDto;
import lotto.util.ManualNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.util.Rank;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoUI lottoUI;
    private MatchNumber matchNumber;
    private Lottos lottos;
    private Money money;

    public LottoController() {
        lottoUI = new LottoUI();
    }

    public void buyLotto() {
        money = new Money(lottoUI.getMoneyFromUser());
        NumOfLotto numOfManual = new NumOfLotto(lottoUI.getNumOfManualFromUser());
        NumOfLotto numOfAuto = money.howMany().minus(numOfManual);

        List<Lotto> manualLottoList = buyManualLotto(numOfManual);
        List<Lotto> autoLottoList = buyAutoLotto(numOfAuto);

        lottoUI.printLottosMessage(numOfManual, numOfAuto);
        lottos = Lottos.of(manualLottoList, autoLottoList);
        lottoUI.printLottos(LottosDto.from(lottos));
    }

    private List<Lotto> buyManualLotto(NumOfLotto numOfManual) {
        lottoUI.printManualLottoMessage();

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numOfManual.getNumOfLotto(); i++) {
            lottoList.add(Lotto.of(
                    ManualNumberGenerator.generate(
                            lottoUI.getManualLottoFromUser())));
        }
        return lottoList;
    }

    private List<Lotto> buyAutoLotto(NumOfLotto numOfAuto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numOfAuto.getNumOfLotto(); i++) {
            lottoList.add(Lotto.of(RandomNumberGenerator.generate()));
        }
        return lottoList;
    }

    public void getWinningNumber() {
        String winningNumberText = lottoUI.getWinningNumberFromUser();
        int bonusNumber = lottoUI.getBonusNumberFromUser();

        matchNumber = MatchNumber.of(winningNumberText, bonusNumber);
    }

    public void matchLotto() {
        List<Rank> ranks = lottos.match(matchNumber);
        Rankings rankings = Rankings.fromRanks(ranks);
        lottoUI.printStatistics(RankingsDto.from(rankings));
        lottoUI.printProfitRate(rankings.getProfitRate(money));
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.buyLotto();
        lottoController.getWinningNumber();
        lottoController.matchLotto();
    }
}
