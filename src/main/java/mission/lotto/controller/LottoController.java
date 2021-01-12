package mission.lotto.controller;

import mission.lotto.domain.LottoAnswer;
import mission.lotto.domain.LottoException;
import mission.lotto.domain.Lottos;
import mission.lotto.domain.UserMoney;
import mission.lotto.util.Statistics;
import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

public class LottoController {

    public static void main(String[] args) throws LottoException {
        UserMoney userMoney = new UserMoney(InputView.enterUerMoney());
        int manualCount = InputView.enterManualCount();
        Lottos lottos = Lottos.buyLottos(manualCount, InputView.enterManualList(manualCount), userMoney);

        OutputView.boughtLottosView(manualCount, lottos);

        LottoAnswer lottoAnswer = new LottoAnswer(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        Statistics statistics = new Statistics(lottos, lottoAnswer);
        OutputView.resultView(statistics.getLottoRanks());
        OutputView.totalEarningsView(statistics.getRateOfProfit(userMoney));
    }

}
