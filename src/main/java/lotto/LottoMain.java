package lotto;

import lotto.domain.*;
import lotto.dto.LottoStatisticDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(InputView.scanMoney());
        LottoGame lotto = new LottoGame(money);

        int manualCount = InputView.scanManualCount();
        if (manualCount > 0) {
            List<String> manualLottos = InputView.scanManualLotto(manualCount);
            lotto.buyLotto(new ManualGenerateStrategy(manualLottos), manualCount);
        }
        UserBuyNumbers userBuyNumbers = lotto.buyLotto(
                new RandomGenerateStrategy(), money.possibleNumberBuy() - manualCount
        );

        OutputView.printLottoCount(manualCount, lotto);
        OutputView.printBuyLotto(userBuyNumbers);

        String winNumbers = InputView.scanWinNumbers();
        int bonusNumber = InputView.scanBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers, bonusNumber);
        LottoStatisticDTO lottoStatisticDTO = lotto.checkLotto(winningNumbers);
        OutputView.printResult(lottoStatisticDTO);
    }
}
