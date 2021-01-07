package mission.lotto;

import mission.lotto.controller.LottoController;
import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int userMoney = InputView.enterUerMoney();

        LottoController controller = new LottoController(userMoney);
        controller.buyLottosAuto();

        OutputView.autoBoughtView(controller);

        controller.setLastWeekWinningNumber(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(controller.getAllLottoCount());
        OutputView.totalEarningsView(controller.getRateOfProfit());
    }

}
