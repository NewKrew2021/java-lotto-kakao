package lotto;

import lotto.domain.*;
import lotto.utils.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());
        LottoTickets lottoTickets = new LottoTickets(money, InputView.inputManualBuyCount());
        LottoGame lotto = new LottoGame(money);

        OutputView.printBuyLotto(lotto.buyLotto(lottoTickets));

        String winNumbers = InputView.inputWinNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(
                Splitter.splitToNumberBy(winNumbers, ","), bonusNumber
        );

        OutputView.printResult(lotto.checkLotto(winningNumbers));
    }
}
