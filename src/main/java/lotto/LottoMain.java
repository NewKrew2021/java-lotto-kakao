package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoMain {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(LottoInputView.inputPurchaseMoney());
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseMoney, LottoInputView.inputManualLottoAmount());

        LottoGroup manualLottoGroup = LottoGroup.createManualLottoGroup(
                LottoInputView.inputManualLottoStrings(purchaseInfo.getManualLottoAmount()));

        LottoGroup autoLottoGroup = LottoGroup.createRandomLottoGroup(purchaseInfo.getAutoLottoAmount());

        LottoOutputView.outputPurchaseAmount(purchaseInfo.getManualLottoAmount(), purchaseInfo.getAutoLottoAmount());
        LottoOutputView.outputLottoGroup(manualLottoGroup);
        LottoOutputView.outputLottoGroup(autoLottoGroup);

        Lotto winningLotto = Lotto.createLottoWithText(LottoInputView.inputWinningLotto());
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(LottoInputView.inputBonusBall());
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusLottoNumber);

        LottoResult manualLottoResult = manualLottoGroup.getLottoResult(winningNumberSet);
        LottoResult autoLottoResult = autoLottoGroup.getLottoResult(winningNumberSet);

        LottoResult combinedLottoResult = LottoResult.combine(manualLottoResult, autoLottoResult);
        LottoOutputView.outputLottoResult(combinedLottoResult, purchaseMoney);
    }
}
