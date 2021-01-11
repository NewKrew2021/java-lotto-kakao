package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(LottoInputView.inputPurchaseMoney());
        LottoOutputView.outputPurchaseAmount(purchaseMoney.getLottoAmount());

        LottoGroup lottoGroup = LottoGroup.createRandomLottoGroup(purchaseMoney.getLottoAmount());
        LottoOutputView.outputLottoGroup(lottoGroup);

        Lotto winningLotto = new Lotto(LottoInputView.inputWinningLotto());
        Ball bonusBall = Ball.of(LottoInputView.inputBonusBall());
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        LottoOutputView.outputLottoResult(lottoResult, purchaseMoney);
    }
}
