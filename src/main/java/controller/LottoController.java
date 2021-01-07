package controller;

import domain.Answer;
import domain.LottoSimulator;
import domain.Lottos;
import domain.PurchaseInfo;
import view.LottoSimulatorView;

public class LottoController {

    private LottoSimulator lottoSimulator;
    private LottoSimulatorView lottoSimulatorView;
    private PurchaseInfo purchaseInfo;
    private Lottos lottos;
    private Answer answer;

    public LottoController() {
        lottoSimulatorView = new LottoSimulatorView();
    }

    public void startLottoSimulation() {
        buyLotto();
        printBuyLotto();
        getAnswerNumbers();
        printLottoResults();
    }

    private void buyLotto() {
        purchaseInfo = new PurchaseInfo(lottoSimulatorView.askMoneyForBuyLotto());
        lottos = new Lottos(purchaseInfo);
        lottoSimulatorView.printBuyLottoCount(purchaseInfo.getPurchaseCount());
    }

    private void printBuyLotto() {
        lottoSimulatorView.printLottos(lottos);
    }

    private void getAnswerNumbers() {
        String answerLottoNumbers = lottoSimulatorView.askLottoNumberForAnswerLotto();
        int bonusNumber = lottoSimulatorView.askBonusNumberForAnswerLotto();
        answer = new Answer(answerLottoNumbers, bonusNumber);
    }

    private void printLottoResults() {
        lottoSimulator = new LottoSimulator(purchaseInfo, lottos, answer);
        lottoSimulatorView.printResult(lottoSimulator.getLottoResults(), lottoSimulator.profitPercentage());
    }
}
