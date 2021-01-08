package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.domain.RandomGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        /*
        1. 구매금액 입력
        2. 구매한 번호 출력
        3. 당첨번호/보너스볼 입력
        4. rank 출력
        5. 수익률 출력
         */
        Money money = new Money(InputView.enterMoney());
        LottoGame lotto = new LottoGame(money);

        OutputView.printLottoCount(money);
        OutputView.printBuyLotto(lotto.buyLotto(new RandomGenerateStrategy()));

        InputView.enterWinNumbers();
        InputView.enterBonusNumber();

//        OutputView.printResult(lotto.getLottoResult());
    }
}
