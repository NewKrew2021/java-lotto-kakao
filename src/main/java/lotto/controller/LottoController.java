package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(LottoInputView.inputPurchaseMoney());
        List<String> lottoTexts = LottoInputView.inputLottoTexts(purchaseMoney);
        LottoGroup lottoGroup = LottoGroup.createLottoGroup(purchaseMoney, lottoTexts);

        LottoOutputView.outputPurchaseQuantity(lottoTexts.size(), lottoGroup);
        LottoOutputView.outputLottoGroup(lottoGroup);

        Lotto winningLotto = new Lotto(LottoInputView.inputWinningLotto());
        Ball bonusBall = Ball.of(LottoInputView.inputBonusBall());
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        LottoOutputView.outputLottoResult(lottoResult, purchaseMoney);
    }
}
