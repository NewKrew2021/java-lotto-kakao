package mission.lotto.controller;

import mission.lotto.domain.Number;
import mission.lotto.domain.*;
import mission.lotto.util.Statistics;
import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public static void main(String[] args) {
        LottoController lc = new LottoController();
        UserMoney userMoney;
        int manualCount;
        Lottos lottos;

        userMoney = lc.registerUserMoney(InputView.enterUerMoney());
        manualCount = InputView.enterManualCount();
        lottos = Lottos.buyLottos(manualCount, InputView.enterManualList(manualCount), userMoney);
        OutputView.boughtLottosView(manualCount, lottos);

        LottoAnswer lottoAnswer = lc.makeLottoAnswer(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(lc.getAllLottoRank(lottos, lottoAnswer));
        OutputView.totalEarningsView(lc.getRateOfProfit(lottos, lottoAnswer, userMoney));
    }

    private UserMoney registerUserMoney(int userMoney) {
        return new UserMoney(userMoney);
    }

    private LottoAnswer makeLottoAnswer(List<Integer> sixNumberList, int bonusNumber) {
        return new LottoAnswer(
                new Lotto(sixNumberList),
                Number.of(bonusNumber));
    }

    private Map<Rank, Integer> getAllLottoRank(Lottos lottos, LottoAnswer lottoAnswer) {
        return Statistics.getAllLottoRank(lottos, lottoAnswer);
    }

    private float getRateOfProfit(Lottos lottos, LottoAnswer lottoAnswer, UserMoney userMoney) {
        return (float) Statistics.getSumAllWinningMoney(lottos, lottoAnswer) / userMoney.getUserMoney();
    }

}
