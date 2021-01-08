package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public static final String SPLIT_DELIMITER = ",";
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;

    private Lottos lottos;
    private Money money;

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.buyLotto();
        lottoController.matchLotto();
    }

    public void buyLotto() {
        money = new Money(LottoUI.getMoneyFromUser());
        List<Lotto> listLottos = new ArrayList<>();

        for (int i = 0; i < money.howMany(); i++) {
            listLottos.add(new Lotto());
        }

        lottos = new Lottos(listLottos);
        LottoUI.printLottos(lottos);
    }

    public void matchLotto() {
        String winningNumberText = LottoUI.getWinningNumberFromUser();
        WinningNumber winningNumber = new WinningNumber(Arrays.stream(split(winningNumberText))
                .map(number -> LottoNumber.of(getParseInt(number)))
                .collect(Collectors.toSet()));
        LottoNumber bonusNumber = LottoNumber.of(LottoUI.getBonusNumberFromUser());

        Statistics statistics = new Statistics(lottos.raffle(winningNumber, bonusNumber));
        LottoUI.printStatistics(statistics.toString(), statistics.getProfitRate(money));
    }

    private int getParseInt(String number) {
        int num = Integer.parseInt(number);
        if (num > MAX_VALUE || num < MIN_VALUE) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        return num;
    }

    private String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }
}
