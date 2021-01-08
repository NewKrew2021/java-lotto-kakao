package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.LottoUI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private static final String SPLIT_DELIMITER = ",";

    private Lottos lottos;
    private Money money;

    private LottoNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.buyLotto();
        lottoController.matchLotto();
    }

    public void buyLotto() {
        money = new Money(LottoUI.getMoneyFromUser());
        lottos = new Lottos(IntStream
                .range(0, (money.howMany(Lotto.getLottoPrice())))
                .mapToObj(num -> new Lotto(new LinkedHashSet<>(randomNumberGenerator
                .getNumbers()
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()))))
                .collect(Collectors.toList()));
        LottoUI.printLottos(lottos);
    }

    public void matchLotto() {
        String winningNumberText = LottoUI.getWinningNumberFromUser();
        Lotto winningNumber = new Lotto(new LinkedHashSet<>(Arrays.stream(split(winningNumberText))
                .map(num -> LottoNumber.of(getParseInt(num)))
                .collect(Collectors.toList())));

        LottoNumber bonusNumber = LottoNumber.of(LottoUI.getBonusNumberFromUser());

        Statistics statistics = lottos.raffle(winningNumber, bonusNumber);
        LottoUI.printStatistics(statistics.getRankings(), statistics.getProfitRate(money));
    }

    private int getParseInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }
}
