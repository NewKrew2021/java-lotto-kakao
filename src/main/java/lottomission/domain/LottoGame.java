package lottomission.domain;

import lottomission.util.RandomForLotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public static int LOTTO_PRICE = 1000;

    public Lottos buyLottos(UserMoney userMoney){
        return new Lottos(IntStream.range(0, userMoney.getPossibleCount())
                .mapToObj(i -> new Lotto(RandomForLotto.getRandomSixIntegerList()))
                .collect(Collectors.toList()));
    }
    public Lottos buyLottosSelf(List<Lotto> lottoList){
        return new Lottos(lottoList);
    }


    public LottoResult getLottoGameResult(Lottos lottos,LottoAnswer answer) {
        Map<LotteryWinnings, Integer> result = Arrays
                .stream(LotteryWinnings.values())
                .collect(Collectors.toMap(lotteryWinnings -> lotteryWinnings, lotteryWinnings -> 0, (a, b) -> b, TreeMap::new));

        lottos.getLottos()
                .stream()
                .map(lotto -> lotto.winningPrize(answer))
                .forEach(winningsStat -> result.put(winningsStat, result.get(winningsStat) + 1));

        result.remove(LotteryWinnings.UNRANKED);
        return new LottoResult(result);
    }

    public List<List<Integer>> getLottosList(Lottos lottos) {
        return lottos.getLottosNumberList();
    }
}
