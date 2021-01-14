package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView;
    private final LottoInputView lottoInputView;

    public LottoController() {
        lottoOutputView = new LottoOutputView();
        lottoInputView = new LottoInputView();
    }

    public void startLottoGame() {
        Amount amount = lottoInputView.getLottoBuyAmount();
        lottoOutputView.printInputQuantityPhrase(amount.BuyCount());
        Lottos lottos = buyLotto(amount);
        lottoOutputView.printLottos(lottos);
        WonLotto wonLotto = createWonLotto();
        LottoResult lottoResult = new LottoResult(lottos.lottosResult(wonLotto));
        lottoOutputView.WonResultPhrase();
        lottoOutputView.printSameCountPhrase(lottoResult.toString());
        lottoOutputView.printProfitRatio(amount.profitRatio(lottoResult.totalPrize()));
    }

    public Lottos buyLotto(Amount amount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount.BuyCount(); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public WonLotto createWonLotto() {
        Lotto lotto = new Lotto(lottoInputView.getWonLotto());
        LottoNumber bonusBall = lottoInputView.getBonusBall();
        return new WonLotto(lotto, bonusBall);
    }

}
