package controller;

import domain.LottoSimulator;
import view.LottoSimulatorView;

public class LottoController {

    private LottoSimulator lottoSimulator;
    private LottoSimulatorView lottoSimulatorView;

    public LottoController() {
        lottoSimulatorView = new LottoSimulatorView();
    }

    public void startLottoSimulator() {
        buyAutoLotto();
        printBuyLottos();
        getAnswerLottoNumbers();
        printLottoResults();
    }

    private void buyAutoLotto() {
        int lottoMoney = lottoSimulatorView.askMoneyToBuyLotto();
        lottoSimulator = new LottoSimulator(lottoMoney);
        while (lottoSimulator.hasMoney()) {
            lottoSimulator.buyAutoLotto();
        }
        lottoSimulatorView.printBuyLottoCount(lottoSimulator.getBuyLottoCount());
    }

    private void printBuyLottos() {
        lottoSimulatorView.printLottos(lottoSimulator.getLottos());
    }

    private void getAnswerLottoNumbers() {
        String answerLottoNumbers = lottoSimulatorView.askLottoNumberToAnswerLotto();
        int bonusNumber = lottoSimulatorView.askBonusNumberToAnswerLotto();
        lottoSimulator.addAnswerLotto(answerLottoNumbers, bonusNumber);
        lottoSimulator.setLottoManager();
    }

    private void printLottoResults() {
        lottoSimulatorView.printResult(lottoSimulator.getLottoResults(), lottoSimulator.profitPercentage());
    }
}
