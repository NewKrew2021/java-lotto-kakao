package lotto.domain;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulation {
    private final Price price;
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private LottoResults lottoResults;

    public LottoSimulation(Price price, String text, String bonusBall, Lottos lottos) {
        this.price = price;
        this.winningLotto = initWinningLotto(StringUtils.splitDigit(text), bonusBall);
        this.lottos = lottos;
    }

    public LottoSimulation(int price, LottoResults lottoResults) {
        this.price = new Price(price);
        this.lottoResults = lottoResults;
        this.lottos = null;
        this.winningLotto = null;
    }

    private WinningLotto initWinningLotto(String[] digits, String bonusBall) {
        List<Integer> lotto = new ArrayList<>();

        for (String digit : digits) {
            lotto.add(Integer.parseInt(digit.trim()));
        }

        return new WinningLotto(new Lotto(lotto), new LottoNumber(Integer.parseInt(bonusBall)));
    }

    public void confirm() {
        lottoResults = lottos.allCompare(winningLotto);
    }

    public double getYield() {
        return (double) lottoResults.getReward() / price.getPrice();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
