package lottoMission;

import lottoMission.controller.LottoController;
import lottoMission.view.InputView;
import lottoMission.view.OutputView;

public class Main {

    public static void main(String[] args) {

        int userMoney = InputView.enterUerMoney();

        LottoController controller = new LottoController(userMoney);
        controller.buyLottos();

        OutputView.autoBoughtView(controller);
        controller.setLastWeekWinningNumber(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(controller);
        OutputView.totalEarningsView(controller);
    }
}