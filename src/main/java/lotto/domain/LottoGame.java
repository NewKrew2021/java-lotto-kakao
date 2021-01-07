package lotto.domain;

import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final TotalUserBuyNumbers totalUserBuyNumbers;

    public LottoGame(int money) {
        this.money = new Money(money);
        this.totalUserBuyNumbers = new TotalUserBuyNumbers();
    }

//    private void buyLotto() {
//        for (int i = 0; i < possibleNumberBuy(); i++) {
//            totalUserBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(new RandomGenerateStrategy()));
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(money, lottoGame.money) && Objects.equals(totalUserBuyNumbers, lottoGame.totalUserBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, totalUserBuyNumbers);
    }
}
