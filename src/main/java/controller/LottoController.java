package controller;

import domain.*;
import view.LottoSimulatorView;

public class LottoController {

    private LottoSimulator lottoSimulator;
    private LottoSimulatorView lottoSimulatorView;
    private PurchaseInfos purchaseInfos;

    private Lottos lottos;
    private Answer answer;

    public LottoController() {
        lottoSimulatorView = new LottoSimulatorView();
    }

    public void startLottoSimulation() {
        getLottoInformation();
        buyLotto();
        printBuyLottoList();
        getAnswerNumbers();
        printLottoResults();
    }

    private void getLottoInformation() {
        purchaseInfos = new PurchaseInfos(lottoSimulatorView.askMoneyForBuyLotto(), lottoSimulatorView.askCountForBuySelfLotto());
        lottos = new Lottos();
    }

    private void buyLotto() {
        if (purchaseInfos.canBuySelfLotto()) {
            lottoSimulatorView.printAskLottoNumberMakeSelfLotto();
        }
        while (purchaseInfos.canBuySelfLotto()) {
            lottos.buyLotto(new SelfLottoStrategy(lottoSimulatorView.askLottoNumberForMakeSelfLotto()));
            purchaseInfos.buySelfLotto();
        }
        while (purchaseInfos.canBuyAutoLotto()) {
            lottos.buyLotto(new RandomLottoStrategy());
            purchaseInfos.buyAutoLotto();
        }
    }

    private void printBuyLottoList() {
        lottoSimulatorView.printBuyLottoCount(purchaseInfos.getNeededSelfLottoCount(), purchaseInfos.getNeededAutoLottoCount());
        lottoSimulatorView.printLottos(lottos);
    }

    private void getAnswerNumbers() {
        Lotto answerLotto = new Lotto(new SelfLottoStrategy(lottoSimulatorView.askLottoNumberForAnswerLotto()));
        int bonusNumber = lottoSimulatorView.askBonusNumberForAnswerLotto();
        answer = new Answer(answerLotto, bonusNumber);
    }

    private void printLottoResults() {
        lottoSimulator = new LottoSimulator(lottos, answer);
        lottoSimulatorView.printResult(lottoSimulator.getLottoResults(), lottoSimulator.getProfit());
    }
}
