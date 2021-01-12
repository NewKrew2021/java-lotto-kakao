package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    public static void main(String[] args) {
        Money money = inputMoney();
        Lottos lottos = buyLotto(money);
        matchLotto(lottos, money);
    }

    private static Money inputMoney() {
        return new Money(InputView.getMoneyFromUser());
    }

    private static Lottos buyLotto(Money money) {
        int selfLottoCount = InputView.getSelfLottoCountFromUser();
        int randomLottoCount = money.howMany(Lotto.LOTTO_PRICE) - selfLottoCount;

        Lottos lottos = new Lottos(buySelfLottos(selfLottoCount), randomLottoCount);
        OutputView.printLottoCount(selfLottoCount, randomLottoCount);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private static List<List<Integer>> buySelfLottos(int selfLottoCount) {
        OutputView.printSelfLottoNumberInputGuide();
        return IntStream.range(0, selfLottoCount)
                .mapToObj(num -> InputView.getSelfLottoNumberFromUser())
                .collect(Collectors.toList());
    }

    private static void matchLotto(Lottos lottos, Money money) {
        WinningLotto winningNumber = new WinningLotto(InputView.getWinningNumberFromUser(), InputView.getBonusNumberFromUser());
        OutputView.printStatistics(new Statistics(lottos.raffle(winningNumber), money));
    }
}
