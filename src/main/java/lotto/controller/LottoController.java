package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottosDto;
import lotto.dto.RankingsDto;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.util.Rank;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoUI lottoUI;
    private final LottoNumberGenerator lottoNumberGenerator;
    private MatchNumber matchNumber;
    private Lottos lottos;
    private Money money;

    public LottoController() {
        lottoUI = new LottoUI();
        lottoNumberGenerator = new RandomNumberGenerator();
    }

    public void buyLotto() {
        money = new Money(lottoUI.getMoneyFromUser());

        int numOfManual = lottoUI.getNumOfManualFromUser();
        int numOfAuto = money.howMany() - numOfManual;

        List<Lotto> manualLottoList = buyManualLotto(numOfManual);
        List<Lotto> autoLottoList = buyAutoLotto(numOfAuto, lottoNumberGenerator);

        lottoUI.printLottosMessage(numOfManual, numOfAuto);
        lottos = Lottos.of(manualLottoList, autoLottoList);
        lottoUI.printLottos(LottosDto.from(lottos));
    }

    private List<Lotto> buyManualLotto(int numOfManual) {
        lottoUI.printManualLottoMessage();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numOfManual; i++) {
            lottoList.add(Lotto.manualGenerate(
                    lottoUI.getManualLottoFromUser()));
        }
        return lottoList;
    }

    private List<Lotto> buyAutoLotto(int numOfAuto, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numOfAuto; i++) {
            lottoList.add(Lotto.autoGenerate(lottoNumberGenerator));
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
}
