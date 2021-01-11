package mission.lotto.controller;

import mission.lotto.domain.Number;
import mission.lotto.domain.*;
import mission.lotto.util.RandomUtil;
import mission.lotto.util.Statistics;
import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private UserMoney userMoney;
    private Lottos lottos;

    public void start() {
        registerUserMoney(InputView.enterUerMoney());
        buyLottos(new RandomUtil(), userMoney);
        OutputView.autoBoughtView(lottos);

        LottoAnswer lottoAnswer = makeLottoAnswer(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(getAllLottoRank(lottoAnswer));
        OutputView.totalEarningsView(getRateOfProfit(lottoAnswer));
    }

    private void registerUserMoney(int userMoney) {
        this.userMoney = new UserMoney(userMoney);
    }

    private void buyLottos(NumGenerator numGenerator, UserMoney userMoney) {
        this.lottos = Lottos.buyLottos(numGenerator, userMoney);
    }

    private LottoAnswer makeLottoAnswer(List<Integer> sixNumberList, int bonusNumber) {
        return new LottoAnswer(
                new Lotto(sixNumberList),
                new Number(bonusNumber));
    }

    private Map<Rank, Integer> getAllLottoRank(LottoAnswer lottoAnswer) {
        return Statistics.getAllLottoRank(lottos, lottoAnswer);
    }

    private float getRateOfProfit(LottoAnswer lottoAnswer) {
        return (float) Statistics.getSumAllWinningMoney(lottos, lottoAnswer) / userMoney.getUserMoney();
    }

}
