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
    private LottoAnswer answer;
    private final int LOTTO_PRICE = 1000;

    public LottoController() {

    }

    public LottoController(int userMoney) {
        this.userMoney = new UserMoney(userMoney);
        this.tryNumber = new TryNumber(userMoney / LOTTO_PRICE);
    }

    public void start() {
        int userMoney = InputView.enterUerMoney();

        LottoController controller = new LottoController(userMoney);
        controller.buyLottos(RandomUtil::getRandomSixIntegerList);

        OutputView.autoBoughtView(controller);

        controller.setLastWeekWinningNumber(
                InputView.enterLastWeekWinningNumbers(),
                InputView.enterLastWeekBonusNumber());

        OutputView.resultView(controller.getAllLottoCount());
        OutputView.totalEarningsView(controller.getRateOfProfit());
    }

    public void buyLottos(NumGenerator numberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        while (this.tryNumber.hasNext()) {
            lottoList.add(new Lotto(numberGenerator.getSixNumbers()));
            this.tryNumber.useTryNumberCount();
        }
        this.lottos = new Lottos(lottoList);
    }

    public void setLastWeekWinningNumber(List<Integer> sixNumberList, int bonusNumber) {
        this.answer = new LottoAnswer(
                new LottoNumbers(sixNumberList),
                new Number(bonusNumber));
    }

    public Map<Rank, Integer> getAllLottoCount() {
        return lottos.getAllLottoRank(answer);
    }

    public float getRateOfProfit() {
        return (float) lottos.getSumAllWinningMoney(answer) / userMoney.getUserMoney();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
