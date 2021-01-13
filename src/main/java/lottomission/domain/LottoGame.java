package lottomission.domain;

import lottomission.domain.exception.InvalidLottoLengthException;
import lottomission.util.RandomForLotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public static int LOTTO_PRICE = 1000;

    public Lottos buyLottos(UserMoney totalUserMoney, List<List<Integer>> selfLottosNumberList){
        if(!checkLottosNumberList(selfLottosNumberList)){
            throw new InvalidLottoLengthException();
        }

        List<Lotto> combineLottoList = selfLottosNumberList.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        combineLottoList.addAll(IntStream.range(0, totalUserMoney.getPossibleCount() - selfLottosNumberList.size())
                .mapToObj(i -> new Lotto(RandomForLotto.getRandomSixIntegerList()))
                .collect(Collectors.toList()));

        return new Lottos(combineLottoList);
    }

    private boolean checkLottosNumberList(List<List<Integer>> lottosNumberList){
        return lottosNumberList
                .stream()
                .allMatch(lottoNumberList -> new HashSet<>(lottoNumberList).size() == LottoNumbers.MAX_NUMBERS_LENGTH);
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
}
