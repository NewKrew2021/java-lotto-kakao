package LottoMission.controller;

import LottoMission.domain.*;
import LottoMission.domain.Number;
import LottoMission.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private UserMoney userMoney;
    private TryNumber tryNumber;
    private Lottos lottos;
    private LottoAnswer answer;
    private final int LOTTO_PRICE = 1000;

    public LottoController(int userMoney) {
        this.userMoney = new UserMoney(userMoney);
        this.tryNumber = new TryNumber(userMoney / LOTTO_PRICE);
    }

    public void buyLottosAuto() {
        List<Lotto> lottoList = new ArrayList<>();
        while (this.tryNumber.canTry()) {
            lottoList.add(new Lotto(RandomUtil.getRandomSixIntegerList()));
            this.tryNumber.useTryNumberCount();
        }
        this.lottos = new Lottos(lottoList);
    }

    public void buyLottosSelf(Lottos lottos) {
        this.lottos = lottos;
    }

    public void setLastWeekWinningNumber(List<Integer> sixNumberList, int bonusNumber) {
        this.answer = new LottoAnswer(
                new LottoNumbers(sixNumberList),
                new Number(bonusNumber));
    }

    public Map<Rank, Integer> getAllLottoCount() {
        return lottos.getAllLottoRankCount(answer);
    }

    public float getRateOfProfit() {
        return (float) lottos.getSumAllWinningMoney(answer) / userMoney.getUserMoney();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
