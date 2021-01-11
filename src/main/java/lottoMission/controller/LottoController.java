package lottomission.controller;

import lottomission.domain.*;
import lottomission.util.RandomForLotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    private UserMoney userMoney;
    private LottoGame lottoGame;
    private LottoResult lottoResult;

    public static final int LOTTO_PRICE = 1000;

    public LottoController(int userMoney){
        this.userMoney = new UserMoney(userMoney);
        this.lottoGame = new LottoGame();
    }

    public void buyLottos(){
        this.lottoGame.buyLottos(createRandomLottoList());
    }

    private List<Lotto> createRandomLottoList(){
        return IntStream.range(0, userMoney.getPossibleCount())
                .mapToObj(i -> new Lotto(RandomForLotto.getRandomSixIntegerList()))
                .collect(Collectors.toList());
    }

    public void buyLottoSelf(List<Lotto> lottoList){
        this.lottoGame.buyLottos(lottoList);
    }


    public void setLastWeekWinningNumber(List<Integer> sixNumberList, int bonusNumber){
        this.lottoGame.setLottoAnswer(sixNumberList, bonusNumber);
    }

    public void calLottoResult(){
        this.lottoResult = new LottoResult(lottoGame.getAllLottoRankCount());
    }

    public Map<LotteryWinnings,Integer> getAllLottoCount(){
        return this.lottoResult.getRankCount();
    }

    public float getRateOfProfit() {
        return this.lottoResult.getRateOfProfitResult(userMoney);
    }

    public List<List<Integer>> getLottosList() {
        return lottoGame.getLottosList();
    }
}
