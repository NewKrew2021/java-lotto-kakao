package lottomission.domain;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<LotteryWinnings, Integer> result = Arrays
                .stream(LotteryWinnings.values())
                .collect(Collectors.toMap(lotteryWinnings -> lotteryWinnings, lotteryWinnings -> 0, (a, b) -> b, TreeMap::new));

        lottos.getLottos()
                .stream()
                .map(lotto -> lotto.winningPrize(answer))
                .forEach(winningsStat -> result.put(winningsStat, result.get(winningsStat) + 1));

        result.remove(LotteryWinnings.UNRANKED);
        return result;
    }

    public List<List<Integer>> getLottosList() {
        return lottos.getLottosNumberList();
    }
}
