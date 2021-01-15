package controller;

import domain.*;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static Money money;

    public static void main(String[] args) {
        List<String> manualLottos = buyManualLotto();

        int manualLottoCount = manualLottos.size();
        int autoLottoCount = money.getAutoLottoCount(manualLottoCount);

        Lottos lottos = new Lottos(manualLottos, autoLottoCount);
        LottoOutputView.printBuyLottoCount(manualLottoCount, autoLottoCount);

        printBuyLottos(lottos);
        AnswerLotto answerLotto = getAnswerLottoNumbers();

        LottoResult lottoResult = new LottoResult(answerLotto, lottos);
        LottoOutputView.printResult(lottoResult, lottoResult.profitPercentage(money));
    }

    private static List<String> buyManualLotto() {
        money = new Money(LottoInputView.askMoneyToBuyLotto());

        int manualLottoCount = LottoInputView.askLottoPurchaseCount();
        money.checkCanBuy(manualLottoCount);

        LottoOutputView.askManualLottoNumbers();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            inputs.add(LottoInputView.inputManualLotto());
        }
        return inputs;
    }

    private static void printBuyLottos(Lottos lottos) {
        LottoOutputView.printLottos(lottos);
    }

    private static AnswerLotto getAnswerLottoNumbers() {
        String answerLottoNumbers = LottoInputView.askLottoNumberToAnswerLotto();
        int bonusNumber = LottoInputView.askBonusNumberToAnswerLotto();
        return new AnswerLotto(answerLottoNumbers, bonusNumber);
    }
}

