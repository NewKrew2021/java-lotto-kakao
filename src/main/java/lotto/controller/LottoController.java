package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoController {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MAX_VALUE = 45;
    private static final int MIN_VALUE = 1;

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
        List<Lotto> listLottos = new ArrayList<>();

        for (int i = 0; i < money.howMany(); i++) {
            listLottos.add(new Lotto(new TreeSet<>(randomNumberGenerator.getNumbers().stream()
                    .map(num -> LottoNumber.of(num))
                    .collect(Collectors.toList()))));
        }

        lottos = new Lottos(listLottos);
        LottoUI.printLottos(lottos);
    }

    public void matchLotto() {
        String winningNumberText = LottoUI.getWinningNumberFromUser();
        Lotto winningNumber = new Lotto(new TreeSet<>(Arrays.stream(split(winningNumberText))
                .map(num -> LottoNumber.of(getParseInt(num)))
                .collect(Collectors.toList())));

        LottoNumber bonusNumber = LottoNumber.of(LottoUI.getBonusNumberFromUser());

        Statistics statistics = new Statistics(lottos.raffle(winningNumber, bonusNumber));
        LottoUI.printStatistics(statistics.toString(), statistics.getProfitRate(money));
    }

    private int getParseInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }
}
