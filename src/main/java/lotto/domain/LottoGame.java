package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final TotalUserBuyNumbers totalUserBuyNumbers;

    public LottoGame(Money money) {
        this.money = money;
        this.totalUserBuyNumbers = new TotalUserBuyNumbers();
    }

    public List<List<String>> buyLotto(GenerateStrategy generateStrategy) {
        for (int i = 0; i < money.possibleNumberBuy(); i++) {
            totalUserBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(generateStrategy));
        }
        return totalUserBuyNumbers.convertToString();
    }

    public List<RankState> getLottoResult(WinAndBonusNumbers winAndBonusNumbers) {
        return this.totalUserBuyNumbers.getAllRankResult(winAndBonusNumbers);
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
