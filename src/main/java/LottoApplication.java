import lotto.LottoManager;
import view.InputView;
import view.OutputView;

public class LottoApplication {
    private static LottoManager lottoManager;

    public static void main(String[] arg) {
        initLottoManager();
        buyLottos();
        printLottos();
        checkLottos();
        printResults();
    }

    private static void initLottoManager() {
        lottoManager = new LottoManager();
    }

    private static void buyLottos() {
        lottoManager.buyRandomLottos(InputView.readMoney());
    }

    private static void printLottos() {
        OutputView.printNumberOfLottos(lottoManager.getNumberOfLottos());
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
}
