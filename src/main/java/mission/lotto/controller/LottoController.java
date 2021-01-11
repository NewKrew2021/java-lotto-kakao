package mission.lotto.controller;

import mission.lotto.domain.Number;
import mission.lotto.domain.*;
import mission.lotto.util.RandomUtil;
import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private UserMoney userMoney;
    private TryNumber tryNumber;
    private Lottos lottos;

    public void start() {
        registerUserMoney(InputView.enterUerMoney());

        buyLottos(RandomUtil::getRandomSixIntegerList);

        OutputView.autoBoughtView(lottos);

        LottoAnswer lottoAnswer = makeLottoAnswer(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(getAllLottoRank(lottoAnswer));
        OutputView.totalEarningsView(getRateOfProfit(lottoAnswer));
    }

    private void registerUserMoney(int userMoney) {
        this.userMoney = new UserMoney(userMoney);
        int LOTTO_PRICE = 1000;
        this.tryNumber = new TryNumber(userMoney / LOTTO_PRICE);
    }

    private void buyLottos(NumGenerator numberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        while (this.tryNumber.hasNext()) {
            lottoList.add(new Lotto(numberGenerator.getSixNumbers()));
            this.tryNumber.useTryNumberCount();
        }
        this.lottos = new Lottos(lottoList);
    }

    private LottoAnswer makeLottoAnswer(List<Integer> sixNumberList, int bonusNumber) {
        return new LottoAnswer(
                new LottoNumbers(sixNumberList),
                new Number(bonusNumber));
    }

    private Map<Rank, Integer> getAllLottoRank(LottoAnswer lottoAnswer) {
        return lottos.getAllLottoRank(lottoAnswer);
    }

    private float getRateOfProfit(LottoAnswer lottoAnswer) {
        return (float) lottos.getSumAllWinningMoney(lottoAnswer) / userMoney.getUserMoney();
    }

}
