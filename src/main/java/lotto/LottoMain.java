package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.domain.RandomGenerateStrategy;
import lotto.domain.WinningNumbers;
import lotto.utils.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(InputView.scanMoney());
        LottoGame lotto = new LottoGame(money);

        OutputView.printLottoCount(money);
        OutputView.printBuyLotto(lotto.buyLotto(new RandomGenerateStrategy()));

        String winNumbers = InputView.scanWinNumbers();
        int bonusNumber = InputView.scanBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers, bonusNumber);

        OutputView.printResult(lotto.checkLotto(winningNumbers));
    }
}
