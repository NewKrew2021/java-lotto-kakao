package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import lotto.exception.IllegalManualCountException;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private static final int MIN_MANUAL_COUNT = 0;
    private static final String NEGATIVE_MANUAL_COUNT_MESSAGE = MIN_MANUAL_COUNT+"개 이상의 로또만 구매 가능합니다.";
    private static final String EXCESS_MANUAL_COUNT_MESSAGE = "구매 가능한 로또의 수를 초과했습니다.";

    private final Money money;
    private final UserBuyNumbers userBuyNumbers;

    public LottoGame(Money money) {
        this.money = money;
        this.userBuyNumbers = new UserBuyNumbers();
    }

    public UserBuyNumbers buyLotto(GenerateStrategy generateStrategy, int lottoCount) {
        validateManualCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            userBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(generateStrategy));
        }
        return userBuyNumbers;
    }

    private void validateManualCount(int manualCount) {
        if (manualCount < 0) {
            throw new IllegalManualCountException(NEGATIVE_MANUAL_COUNT_MESSAGE);
        }
        if (manualCount > getLottoCount()) {
            throw new IllegalManualCountException(EXCESS_MANUAL_COUNT_MESSAGE);
        }
    }

    public int getLottoCount() {
        return money.possibleNumberBuy();
    }

    public LottoStatisticDTO checkLotto(WinningNumbers winningNumbers) {
        LottoStatisticDTO responseLottoStatistic = new LottoStatisticDTO();
        List<RankState> eachLottoResult = userBuyNumbers.checkLottoResult(winningNumbers);
        responseLottoStatistic.setRankCount(StatisticCalculator.getRankCount(eachLottoResult));
        responseLottoStatistic.setProfitRate(StatisticCalculator.getProfitRate(eachLottoResult, money));
        return responseLottoStatistic;
    }

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
