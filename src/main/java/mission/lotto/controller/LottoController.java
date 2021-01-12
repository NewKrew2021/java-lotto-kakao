package mission.lotto.controller;

import mission.lotto.domain.Number;
import mission.lotto.domain.*;
import mission.lotto.util.Statistics;
import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) throws LottoException {
        UserMoney userMoney = new UserMoney(InputView.enterUerMoney());
        int manualCount = InputView.enterManualCount();
        Lottos lottos = Lottos.buyLottos(manualCount, InputView.enterManualList(manualCount), userMoney);

        OutputView.boughtLottosView(manualCount, lottos);

        LottoAnswer lottoAnswer = makeLottoAnswer(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(Statistics.getAllLottoRank(lottos, lottoAnswer));
        OutputView.totalEarningsView(Statistics.getRateOfProfit(lottos, lottoAnswer, userMoney));
    }

    private static LottoAnswer makeLottoAnswer(List<Integer> sixNumberList, int bonusNumber) {
        return new LottoAnswer(
                new Lotto(sixNumberList),
                Number.of(bonusNumber));
    }

}
