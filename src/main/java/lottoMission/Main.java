package lottomission;

import lottomission.controller.LottoController;
import lottomission.view.InputView;
import lottomission.view.OutputView;

public class Main {

    public static void main(String[] args) {

        int userMoney = InputView.enterUerMoney();

        LottoController controller = new LottoController(userMoney);
        controller.buyLottos();

        OutputView.autoBoughtView(controller);
        controller.setLastWeekWinningNumber(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        controller.calLottoResult();
        OutputView.resultView(controller);
        OutputView.totalEarningsView(controller);
    }
}