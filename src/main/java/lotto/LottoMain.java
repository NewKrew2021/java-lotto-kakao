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
        Money money = new Money(InputView.enterMoney());
        LottoGame lotto = new LottoGame(money);

        OutputView.printLottoCount(money);
        OutputView.printBuyLotto(lotto.buyLotto(new RandomGenerateStrategy()));

        String winNumbers = InputView.enterWinNumbers();
        int bonusNumber = InputView.enterBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(
                Splitter.splitToNumberBy(winNumbers, ","), bonusNumber
        );

        OutputView.printResult(lotto.checkLotto(winningNumbers));
    }
}
