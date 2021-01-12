package controller;

import domain.*;
import utils.StringUtils;
import view.LottoSimulatorView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private static final long PERCENTAGE = 100;
    private final LottoSimulatorView lottoSimulatorView;
    private Money money;

    public LottoController() {
        lottoSimulatorView = new LottoSimulatorView();
    }

    public void startLottoSimulator() {
        Lottos manualLottos = buyManualLotto();
        Lottos autoLottos = buyAutoLotto(money.getLottoCount(manualLottos.size()), manualLottos.size());
        Lottos totalLottos = manualLottos.combineLottos(autoLottos);
        printBuyLottos(totalLottos);
        AnswerLotto answerLotto = getAnswerLottoNumbers();
        printLottoResults(answerLotto, totalLottos);
    }

    private Lottos buyManualLotto() {
        this.money = new Money(lottoSimulatorView.askMoneyToBuyLotto());

        int manualLottoCount = lottoSimulatorView.askLottoPurchaseCount();
        money.checkCanBuy(manualLottoCount);

        if (manualLottoCount == 0) {
            return new Lottos(new ArrayList<>());
        }
        lottoSimulatorView.askManualLottoNumbers();
        List<Lotto> lottos = generateManualLottos(manualLottoCount);

        return new Lottos(lottos);
    }

    private List<Lotto> generateManualLottos(int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            List<String> lottoString = StringUtils.splitText(lottoSimulatorView.inputManualLotto());
            lottos.add(new Lotto(new ManualLottoGenerateStrategy(lottoString)));
        }
        return lottos;
    }

    private Lottos buyAutoLotto(int autoLottoCount, int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new RandomLottoGenerateStrategy()));
        }
        lottoSimulatorView.printBuyLottoCount(manualLottoCount, autoLottoCount);
        return new Lottos(lottos);
    }

    private AnswerLotto getAnswerLotto(String inputTexts, int bonus) {
        List<Integer> lotto = StringUtils.splitText(inputTexts).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new AnswerLotto(new Lotto(lotto), new LottoNumber(bonus));
    }

    private int getWinningMoney(AnswerLotto answerLotto, Lottos lottos) {
        return lottosResult(answerLotto, lottos).getWinningMoney();
    }

    private LottoResult getLottoResults(AnswerLotto answerLotto, Lottos lottos) {
        return lottosResult(answerLotto, lottos);
    }

    private long profitPercentage(AnswerLotto answerLotto, Lottos lottos) {
        return getWinningMoney(answerLotto, lottos) * PERCENTAGE / money.getMoney();
    }

    private LottoResult lottosResult(AnswerLotto answerLotto, Lottos lottos) {
        return new LottoResult(answerLotto, lottos);
    }

    private void printBuyLottos(Lottos lottos) {
        lottoSimulatorView.printLottos(lottos);
    }

    private AnswerLotto getAnswerLottoNumbers() {
        String answerLottoNumbers = lottoSimulatorView.askLottoNumberToAnswerLotto();
        int bonusNumber = lottoSimulatorView.askBonusNumberToAnswerLotto();
        return getAnswerLotto(answerLottoNumbers, bonusNumber);
    }

    private void printLottoResults(AnswerLotto answerLotto, Lottos lottos) {
        lottoSimulatorView.printResult(getLottoResults(answerLotto, lottos), profitPercentage(answerLotto, lottos));
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLottoSimulator();
    }
}

