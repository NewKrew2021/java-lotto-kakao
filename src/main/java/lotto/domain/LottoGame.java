package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final TotalUserBuyNumbers totalUserBuyNumbers;
    private final WinAndBonusNumbers winAndBonusNumbers;

    public LottoGame(int money) {
        this.money = new Money(money);
        this.totalUserBuyNumbers = new TotalUserBuyNumbers();
        this.winAndBonusNumbers = new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

//    public void play() {
//        buyLotto();
//    }
//
//    public void addBuyNumbers(UserBuyNumbers userBuyNumbers) {
//        totalUserBuyNumbers.addBuyNumbers(userBuyNumbers);
//    }
//
//    private void buyLotto() {
//        for (int i = 0; i < money.possibleNumberBuy(); i++) {
//            totalUserBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(new RandomGenerateStrategy()));
//        }
//    }

    private List<RankState> getLottoResult() {
        return this.totalUserBuyNumbers.getAllRankResult(this.winAndBonusNumbers);
    }

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
