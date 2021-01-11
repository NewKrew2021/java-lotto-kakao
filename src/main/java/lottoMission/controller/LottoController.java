package lottoMission.controller;

import lottoMission.domain.*;
import lottoMission.util.RandomForLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private LottoGame lottoGame;
    private Lottos lottos;
    private LottoAnswer answer;

    public LottoController(int userMoney){
        this.lottoGame = new LottoGame(userMoney);
    }

    public void buyLottos(){
        this.lottos = lottoGame.buyLottosAuto();
    }

    public void buyLottosSelf(Lottos lottos){
        this.lottos = lottos;
    }

    public void setLastWeekWinningNumber(List<Integer> sixNumberList, int bonusNumber){
        this.answer = new LottoAnswer(
                new LottoNumbers(sixNumberList),
                new LottoNumber(bonusNumber));
    }

    public Map<LotteryWinnings,Integer> getAllLottoCount(){
        return lottos.getAllLottoRankCount(answer);
    }

    public float getRateOfProfit() {
        return (float) lottos.getSumAllWinningMoney(answer) / lottoGame.getUserMoney();
    }

    public List<List<Integer>> getLottosList() {
        return lottos.getLottosNumberList();
    }
}
