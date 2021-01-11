package controller;

import domain.*;
import view.LottoSimulatorView;

public class LottoController {

    private LottoSimulator lottoSimulator;
    private LottoSimulatorView lottoSimulatorView;

    private PurchaseInfo selfLottoPurchaseInfo;
    private PurchaseInfo autoLottoPurchaseInfo;

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
        selfLottoPurchaseInfo = new PurchaseInfo(lottoSimulatorView.askMoneyForBuyLotto(), lottoSimulatorView.askCountForBuySelfLotto());

        long remainMoney = selfLottoPurchaseInfo.getInitialPrice() - selfLottoPurchaseInfo.getNeedLottoPurchaseCount() * PurchaseInfo.LOTTE_PRICE;
        autoLottoPurchaseInfo = new PurchaseInfo(remainMoney, remainMoney / PurchaseInfo.LOTTE_PRICE);

        lottos = new Lottos();
    }

    private void buyLotto() {
        if(selfLottoPurchaseInfo.canBuyLotto()) {
            lottoSimulatorView.printAskLottoNumberMakeSelfLotto();
        }
        while(selfLottoPurchaseInfo.canBuyLotto()) {
            lottos.buyLotto(new SelfLottoStrategy(lottoSimulatorView.askLottoNumberForMakeSelfLotto()));
            selfLottoPurchaseInfo.buyLotto();
        }
        while(autoLottoPurchaseInfo.canBuyLotto()) {
            lottos.buyLotto(new RandomLottoStrategy());
            autoLottoPurchaseInfo.buyLotto();
        }
    }

    private void printBuyLottoList() {
        lottoSimulatorView.printBuyLottoCount(selfLottoPurchaseInfo.getNeedLottoPurchaseCount(),
                lottos.getTotalPurchaseCount() - selfLottoPurchaseInfo.getNeedLottoPurchaseCount());
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
