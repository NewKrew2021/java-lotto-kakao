package lotto.controller;

import lotto.domain.*;
import lotto.exception.FailBuyLottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private static Lottos lottos;
    private static Money money;

    public static void main(String[] args) {
        buyLotto();
        matchLotto();
    }

    private static void buyLotto() {
        money = new Money(InputView.getMoneyFromUser());
        LottoKind lottoKind = getLottoKind(money);
        List<Lotto> lottosList = new ArrayList<>();
        lottosList.addAll(buySelfLottos(lottoKind.getSelfLottoCount()));
        lottosList.addAll(buyRandomLottos(lottoKind.getRandomLottoCount()));
        lottos = new Lottos(lottosList);
        OutputView.printLottoCount(lottoKind);
        OutputView.printLottos(lottos);
    }

    private static LottoKind getLottoKind(Money money) {
        int selfLottoCount = InputView.getSelfLottoCountFromUser();
        int randomLottoCount = money.howMany(Lotto.LOTTO_PRICE) - selfLottoCount;
        if (randomLottoCount < 0) {
            throw new FailBuyLottoException();
        }
        return new LottoKind(selfLottoCount, randomLottoCount);
    }

    private static List<Lotto> buySelfLottos(int selfLottoCount) {
        OutputView.printSelfLottoNumberInputGuide();
        return IntStream.range(0, selfLottoCount)
                .mapToObj(num -> new Lotto(InputView.getSelfLottoNumberFromUser()))
                .collect(Collectors.toList());
    }

    private static List<Lotto> buyRandomLottos(int randomLottoCount) {
        return IntStream.range(0, randomLottoCount)
                .mapToObj(num -> new Lotto())
                .collect(Collectors.toList());
    }

    private static void matchLotto() {
        WinningLotto winningNumber = new WinningLotto(InputView.getWinningNumberFromUser(), InputView.getBonusNumberFromUser());
        OutputView.printStatistics(new Statistics(lottos.raffle(winningNumber), money));
    }
}
