package controller;

import domain.*;
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
        getLottoInformation();
        buyLotto();
        printBuyLottoList();
        getAnswerNumbers();
        printLottoResults();
    }

    private void getLottoInformation() {
        purchaseInfo = new PurchaseInfo(lottoSimulatorView.askMoneyForBuyLotto(), lottoSimulatorView.askCountForBuySelfLotto());
        lottos = new Lottos(purchaseInfo);
    }

    private void buyLotto() {
        lottoSimulatorView.printAskLottoNumberMakeSelfLotto();
        while(!lottos.buyAllSelfLottos()) {
            lottos.buyLotto(new SelfLottoStrategy(lottoSimulatorView.askLottoNumberForMakeSelfLotto()));
        }
        while(!lottos.buyAllAutoLottos()) {
            lottos.buyLotto(new RandomLottoStrategy());
        }
    }

    private void printBuyLottoList() {
        lottoSimulatorView.printBuyLottoCount(purchaseInfo.getSelfLottoPurchaseCount(),
                lottos.getTotalPurchaseCount() - purchaseInfo.getSelfLottoPurchaseCount());
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
