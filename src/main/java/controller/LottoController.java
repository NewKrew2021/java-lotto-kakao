package controller;

import domain.Answer;
import domain.LottoSimulator;
import domain.Lottos;
import view.LottoSimulatorView;

public class LottoController {

    private LottoSimulator lottoSimulator;
    private LottoSimulatorView lottoSimulatorView;
    private Lottos lottos;
    private Answer answer;

    public LottoController() {
        lottoSimulatorView = new LottoSimulatorView();
    }

    public void startLottoSimulator() {
        int initial_money = buyLotto();
        printBuyLotto();
        getAnswerNumbers();
        lottoSimulator = new LottoSimulator(initial_money, lottos, answer);
        printLottoResults();
    }

    private int buyLotto() {
        int initial_money = lottoSimulatorView.askMoneyForBuyLotto();
        lottos = new Lottos(initial_money);
        return initial_money;
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
        lottoSimulatorView.printResult(lottoSimulator.getLottoResults(), lottoSimulator.profitPercentage());
    }
}
