package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {
    private static Lottos lottos;
    private static Money money;
    private static LottoKind lottoKind;

    public static void main(String[] args) {
        inputMoney();
        buyLotto();
        printBuyResult();
        matchLotto();
    }

    private static void inputMoney() {
        money = new Money(InputView.getMoneyFromUser());
        lottoKind = getLottoKind(money);
    }

    private static void buyLotto() {
        lottos = new Lottos(Stream.concat(buySelfLottos(lottoKind.getSelfLottoCount()).stream(), buyRandomLottos(lottoKind.getRandomLottoCount()).stream())
                .collect(Collectors.toList()));
    }

    private static void printBuyResult() {
        OutputView.printLottoCount(lottoKind);
        OutputView.printLottos(lottos);
    }

    private static LottoKind getLottoKind(Money money) {
        int selfLottoCount = InputView.getSelfLottoCountFromUser();
        return new LottoKind(selfLottoCount, money.howMany(Lotto.LOTTO_PRICE) - selfLottoCount);
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
