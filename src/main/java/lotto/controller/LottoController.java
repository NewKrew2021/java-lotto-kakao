package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGeneratorService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoOutputView lottoOutputView;
    private final LottoInputView lottoInputView;
    private final LottoGeneratorService lottoGeneratorService;

    public LottoController() {

        lottoGeneratorService = new LottoGeneratorService();
        lottoOutputView = new LottoOutputView();
        lottoInputView = new LottoInputView();
    }

    public void startLottoGame() {

        Lottos lottos = buyLotto();
        lottoOutputView.printLottos(lottos);

        WonLotto wonLotto = createWonLotto();
        LottoRanks lottoRanks = new LottoRanks(lottos.lottosResult(wonLotto));
        lottoOutputView.WonResultPhrase();
        lottoOutputView.printSameCountPhrase(lottoRanks.toString());
        lottoOutputView.printProfitRatio(lottoRanks.profitRatio());

    }


    public Lottos buyLotto() {

        lottoOutputView.printInputMoneyPhrase();
        Amount amount;
        do {
            amount = lottoInputView.getLottoBuyAmount();
        }
        while (amount == null);
        lottoOutputView.printInputQuantityPhrase(amount.BuyCount());
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount.BuyCount(); i++) {
            lottos.add(lottoGeneratorService.generateLotto());
        }
        return lottos;
    }

    public WonLotto createWonLotto() {

        Lotto lotto;
        lottoOutputView.printInputWonlottoPhrase();
        do {
            lotto = lottoGeneratorService.lottoStringParser(lottoInputView.getWonLotto());
        }
        while (lotto == null);
        lottoOutputView.printInputBonusBallPhrase();
        LottoNumber bonusBall = lottoInputView.getBonusBall();
        return new WonLotto(lotto, bonusBall);
    }


}
