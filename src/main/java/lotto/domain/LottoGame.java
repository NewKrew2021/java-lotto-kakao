package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import lotto.view.OutputView;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final UserBuyNumbers userBuyNumbers;

    public LottoGame(Money money) {
        this.money = money;
        this.userBuyNumbers = new UserBuyNumbers();
    }

    public List<List<String>> buyLotto(LottoTickets lottoTickets) {
        buyLottoManually(lottoTickets);
        buyLottoAuto(lottoTickets);
        return userBuyNumbers.convertToString();
    }

    private void buyLottoManually(LottoTickets lottoTickets) {
        OutputView.printManualInput();
        while (lottoTickets.isManualTicketRemain()) {
            userBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(new ManualGenerateStrategy()));
            lottoTickets.useManualTicket();
        }
    }

    private void buyLottoAuto(LottoTickets lottoTickets) {
        OutputView.printLottoCount(lottoTickets, money);
        while (lottoTickets.isAutoTicketRemain()) {
            userBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(new RandomGenerateStrategy()));
            lottoTickets.useAutoTicket();
        }
    }

    public LottoStatisticDTO checkLotto(WinningNumbers winningNumbers) {
        LottoStatisticDTO responseLottoStatistic = new LottoStatisticDTO();

        StatisticCalculator statCalculator = new StatisticCalculator(
                userBuyNumbers.checkLottoResult(winningNumbers), money);
        responseLottoStatistic.setRankCount(statCalculator.getRankCount());
        responseLottoStatistic.setProfitRate(statCalculator.getProfitRate());

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
