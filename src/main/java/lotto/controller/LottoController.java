package lotto.controller;

import lotto.domain.*;
import lotto.exception.FailBuyLottoException;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {
    private static final String SPLIT_DELIMITER = ", ";

    private Lottos lottos;
    private Money money;

    private final LottoNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.buyLotto();
        lottoController.matchLotto();
    }

    private void buyLotto() {
        OutputView.printMoneyInputGuide();
        money = new Money(InputView.getMoneyFromUser());
        LottoKind lottoKind = getLottoKind(money);
        lottos = new Lottos(Stream.concat(buySelfLottos(lottoKind.getSelfLottoCount()).stream(), buyRandomLottos(lottoKind.getRandomLottoCount()).stream())
                .collect(Collectors.toList()));

        OutputView.printLottoCount(lottoKind);
        OutputView.printLottos(lottos);
    }

    private LottoKind getLottoKind(Money money){
        int selfLottoCount = getSelfLottoCount();
        int randomLottoCount = money.howMany(Lotto.getLottoPrice()) - selfLottoCount;
        if(randomLottoCount < 0){
            throw new FailBuyLottoException();
        }
        return new LottoKind(selfLottoCount, randomLottoCount);
    }

    private List<Lotto> buySelfLottos(int selfLottoCount) {
        OutputView.printSelfLottoNumberInputGuide();
        return IntStream.range(0, selfLottoCount)
                .mapToObj(num -> new Lotto(makeUserLotto()))
                .collect(Collectors.toList());
    }

    private List<Integer> makeUserLotto() {
        return Arrays.stream(split(InputView.getSelfLottoNumberFromUser()))
                .map(this::getParseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private int getSelfLottoCount() {
        OutputView.printSelfLottoCountInputGuide();
        return InputView.getSelfLottoCountFromUser();
    }

    private List<Lotto> buyRandomLottos(int randomLottoCount) {
        return IntStream.range(0, randomLottoCount)
                .mapToObj(num -> new Lotto(randomNumberGenerator))
                .collect(Collectors.toList());
    }

    private void matchLotto() {
        WinningLotto winningNumber = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber();
        Statistics statistics = lottos.raffle(winningNumber, bonusNumber);
        OutputView.printStatistics(statistics.getRankings(), statistics.getProfitRate(money));
    }

    private LottoNumber getBonusNumber() {
        OutputView.printBonusNumberInputGuide();
        return LottoNumber.of(InputView.getBonusNumberFromUser());
    }

    private WinningLotto getWinningLotto() {
        OutputView.printWinningNumberInputGuide();
        return new WinningLotto(Arrays.stream(split(InputView.getWinningNumberFromUser()))
                .map(num -> getParseInt(num))
                .collect(Collectors.toList()));
    }

    private String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }

    private int getParseInt(String number) {
        return Integer.parseInt(number);
    }
}
