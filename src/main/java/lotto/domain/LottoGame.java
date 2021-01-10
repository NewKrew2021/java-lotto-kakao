package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final UserBuyNumbers userBuyNumbers;

    public LottoGame(Money money) {
        this.money = money;
        this.userBuyNumbers = new UserBuyNumbers();
    }

    public List<List<String>> buyLotto(GenerateStrategy generateStrategy) {
        for (int i = 0; i < money.possibleNumberBuy(); i++) {
            userBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(generateStrategy));
        }
        return userBuyNumbers.convertToString();
    }

    public LottoStatisticDTO checkLotto(WinAndBonusNumbers winAndBonusNumbers) {
        LottoStatisticDTO responseLottoStatistic = new LottoStatisticDTO();

        StatisticCalculator statCalculator = new StatisticCalculator(
                userBuyNumbers.checkLottoResult(winAndBonusNumbers), money);
        responseLottoStatistic.setRankCount(statCalculator.getRankCount());
        responseLottoStatistic.setProfitRate(statCalculator.getProfitRate());

        return responseLottoStatistic;
    }
    /*
    두가지 방법
    *****1. resultCalculator 의 public method에 List<RankState>, Money를 넘겨서 List<integer> 순이익? 을 얻고 이것을 DTO로 만들어 checkLotto 의 리턴값으로 사용
         2. 계산로직은 LottoGame 내,혹은 별도의 클래스에서 계싼하고, DTO사용 없이 LottoResult 라는 녀석에
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(money, lottoGame.money) && Objects.equals(userBuyNumbers, lottoGame.userBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, userBuyNumbers);
    }
}
