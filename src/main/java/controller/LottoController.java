package controller;

import domain.LottoGame;
import view.LottoSimulatorView;

public class LottoController {

    private LottoGame lottoGame;
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
        lottoGame = new LottoGame(lottoMoney);
        while (lottoGame.hasMoney()) {
            lottoGame.buyAutoLotto();
        }
        lottoSimulatorView.printBuyLottoCount(lottoGame.getBuyLottoCount());
    }

    private void printBuyLottos() {
        lottoSimulatorView.printLottos(lottoGame.getLottos());
    }

    private void getAnswerLottoNumbers() {
        String answerLottoNumbers = lottoSimulatorView.askLottoNumberToAnswerLotto();
        int bonusNumber = lottoSimulatorView.askBonusNumberToAnswerLotto();
        lottoGame.addAnswerLotto(answerLottoNumbers, bonusNumber);
    }

    private void printLottoResults() {
        lottoSimulatorView.printResult(lottoGame.getLottoResults(), lottoGame.profitPercentage());
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLottoSimulator();
    }
}
