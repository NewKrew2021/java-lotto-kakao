import lotto.Lotto;
import lotto.LottoManager;
import view.InputView;
import view.OutputView;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoApplication {
    private static LottoManager lottoManager;

    public static void main(String[] arg) {
        createLottoManager();
        buyLottos();
        printLottos();
        checkLottos();
        printResults();
    }

    private static void createLottoManager() {
        lottoManager = new LottoManager();
    }

    private static void buyLottos() {
        int money = InputView.readMoney();
        validateMoney(money);

        int numberOfManualLottos = InputView.readNumberOfManualLottos();
        int numberOfRandomLottos = money / Lotto.LOTTO_PRICE - numberOfManualLottos;

        buyManualLottos(numberOfManualLottos);
        buyRandomLottos(numberOfRandomLottos);

        OutputView.printNumberOfLottos(numberOfManualLottos, numberOfRandomLottos);
    }

    private static void buyRandomLottos(int numberOfRandomLottos) {
        for (int i = 0; i < numberOfRandomLottos; i++) {
            lottoManager.buyRandomLotto();
        }
    }

    private static void buyManualLottos(int numberOfManualLottos) {
        OutputView.printAskingManualLottoNumbers();
        for (int i = 0; i < numberOfManualLottos; i++) {
            lottoManager.buyManualLotto(InputView.readLottoNumbers());
        }
    }

    private static void printLottos() {
        OutputView.printLottos(lottoManager.getLottos());
    }

    private static void checkLottos() {
        lottoManager.checkLottos(
                InputView.readWinningLotto(),
                InputView.readBonusNumber()
        );
    }

    private static void printResults() {
        OutputView.printStatistics(lottoManager.makeStatistics());
        OutputView.printEarningRate(lottoManager.getEarningRate());
    }

    private static void validateMoney(int money) {
        if (money <= 0 || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Input number should be multiples of 1000");
        }
    }
}
