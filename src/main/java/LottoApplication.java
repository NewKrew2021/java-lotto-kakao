import lotto.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoApplication {
    private static Lottos lottos;
    private static List<LottoResult> lottoResults;

    public static void main(String[] arg) {
        createLottos();
        buyLottos();
        printLottos();
        checkLottos();
        printResults();
    }

    public static void createLottos() {
        lottos = new Lottos();
    }

    public static void buyLottos() {
        int money = InputView.readMoney();
        validateMoney(money);

        int numberOfManualLottos = InputView.readNumberOfManualLottos();
        int numberOfRandomLottos = money / Lotto.LOTTO_PRICE - numberOfManualLottos;

        buyManualLottos(numberOfManualLottos);
        buyRandomLottos(numberOfRandomLottos);

        OutputView.printNumberOfLottos(numberOfManualLottos, numberOfRandomLottos);
    }

    public static void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void buyRandomLottos(int numberOfRandomLottos) {
        for (int i = 0; i < numberOfRandomLottos; i++) {
            lottos.addLotto(Lotto.generateRandomLotto());
        }
    }

    public static void buyManualLottos(int numberOfManualLottos) {
        if (numberOfManualLottos < 0)
            return;

        OutputView.printAskingManualLottoNumbers();

        for (int i = 0; i < numberOfManualLottos; i++) {
            List<Integer> lottoNumbers = InputView.readLottoNumbers();
            lottos.addLotto(Lotto.generateManualLotto(lottoNumbers));
        }
    }

    private static void printLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLotto(lotto);
        }
    }

    public static void checkLottos() {
        Lotto winningLotto = Lotto.generateManualLotto(InputView.readWinningLotto());
        LottoNumber bonusNumber = LottoNumber.of(InputView.readBonusNumber());

        lottoResults = lottos.checkLottos(winningLotto, bonusNumber);
    }

    private static void printResults() {
        OutputView.printStatistics(makeStatistics());
        OutputView.printEarningRate(getEarningRate());
    }

    public static Map<LottoResult, Long> makeStatistics(){
        return lottoResults.stream().collect(Collectors.groupingBy(lottoResult -> lottoResult, Collectors.counting()));
    }

    public static double getEarningRate()  {
        return (double)(getTotalReward()) / (lottos.getLottos().size() * LOTTO_PRICE);
    }

    public static long getTotalReward() {
        return lottoResults.stream().mapToLong(result -> result.getReward()).sum();
    }
}
