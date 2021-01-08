package lotto;

import lotto.domain.game.LottoRevenueRate;
import lotto.domain.game.LottoTicketCount;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.number.RandomGenerateStrategy;
import lotto.domain.ranking.LottoStatistics;
import lotto.view.InputView;
import lotto.view.LottoNumbersDto;
import lotto.view.LottoStatisticsDto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {

        LottoTicketCount lottoTicketCount = new LottoTicketCount(InputView.inputMoney());
        OutputView.printTicketCount(lottoTicketCount.getTicketCount());

        NumberGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        while (lottoTicketCount.isTicketRemain()) {
            LottoNumbers lottoTicket = LottoNumbers.from(randomGenerateStrategy);
            lottoTickets.add(lottoTicket);
            lottoTicketCount.useTicket();
            OutputView.printTicketNumbers(LottoNumbersDto.from(lottoTicket));
        }

        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinnerTicket winnerTicket = WinnerTicket.of(winnerNumbers, bonusNumber);

        LottoStatistics lottoStatistics = LottoStatistics.of(lottoTickets, winnerTicket);
        OutputView.printWinningStatistics(LottoStatisticsDto.from(lottoStatistics));

        LottoRevenueRate lottoRevenueRate = LottoRevenueRate.of(
                lottoStatistics.calculateTotalPrice(),
                lottoTicketCount.calculateTotalTicketMoney()
        );
        OutputView.printRevenueRate(lottoRevenueRate);
    }
}