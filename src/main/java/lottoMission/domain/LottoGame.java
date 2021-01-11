package lottomission.domain;

import java.util.*;

public class LottoGame {

    private Lottos lottos;
    private LottoAnswer answer;


    public void buyLottos(List<Lotto> lottoList){
        this.lottos = new Lottos(lottoList);
    }

    public void setLottoAnswer(List<Integer> sixNumberList, int bonusNumber){
        this.answer = new LottoAnswer(
                new LottoNumbers(sixNumberList),
                new LottoNumber(bonusNumber));
    }

    public Map<LotteryWinnings, Integer> getAllLottoRankCount() {
        Map<LotteryWinnings, Integer> result = new TreeMap<>();
        for (LotteryWinnings lotteryWinnings : LotteryWinnings.values()) {
            result.put(lotteryWinnings, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            LotteryWinnings winningsStat = lotto.winningPrize(answer);
            result.put(winningsStat, result.get(winningsStat) + 1);
        }
        result.remove(LotteryWinnings.UNRANKED);
        return result;
    }

    public List<List<Integer>> getLottosList() {
        return lottos.getLottosNumberList();
    }
}
