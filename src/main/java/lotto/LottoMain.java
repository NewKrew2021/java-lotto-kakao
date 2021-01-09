package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoMain {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(LottoInputView.inputPurchaseMoney());
        LottoOutputView.outputPurchaseAmount(purchaseMoney.getLottoAmount());

        LottoGroup lottoGroup = LottoGroup.createRandomLottoGroup(purchaseMoney.getLottoAmount());
        LottoOutputView.outputLottoGroup(lottoGroup);

        Lotto winningLotto = new Lotto(LottoInputView.inputWinningLotto());
        LottoNumber bonusLottoNumber = LottoNumber.createLottoNumber(LottoInputView.inputBonusBall());
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusLottoNumber);

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        LottoOutputView.outputLottoResult(lottoResult, purchaseMoney);
    }
}
