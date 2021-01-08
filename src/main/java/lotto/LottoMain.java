package lotto;

import lotto.domain.game.LottoRevenueRate;
import lotto.domain.game.LottoTicketCount;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.number.RandomLottoNumberGenerator;
import lotto.domain.ranking.LottoStatistics;
import lotto.view.InputView;
import lotto.view.LottoNumbersDto;
import lotto.view.LottoStatisticsDto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoTicketCount lottoTicketCount = getLottoTicketCount();
        List<LottoNumbers> lottoTickets = buyLottoTickets(lottoTicketCount);

        WinnerTicket winnerTicket = WinnerTicket.of(InputView.inputWinnerNumbers(), InputView.inputBonusNumber());

        calculateLottoResult(lottoTicketCount, lottoTickets, winnerTicket);
    }

    private static LottoTicketCount getLottoTicketCount() {
        LottoTicketCount lottoTicketCount = new LottoTicketCount(InputView.inputMoney());
        OutputView.printTicketCount(lottoTicketCount);
        return lottoTicketCount;
    }

    private static List<LottoNumbers> buyLottoTickets(LottoTicketCount lottoTicketCount) {
        NumberGenerateStrategy randomGenerateStrategy = new RandomLottoNumberGenerator();

        List<LottoNumbers> lottoTickets = new ArrayList<>();
        while (lottoTicketCount.isTicketRemain()) {
            LottoNumbers lottoTicket = LottoNumbers.from(randomGenerateStrategy);
            lottoTickets.add(lottoTicket);
            lottoTicketCount.useTicket();
            OutputView.printTicketNumbers(LottoNumbersDto.from(lottoTicket));
        }
        return lottoTickets;
    }

    private static void calculateLottoResult(
            LottoTicketCount lottoTicketCount,
            List<LottoNumbers> lottoTickets,
            WinnerTicket winnerTicket
    ) {
        LottoStatistics lottoStatistics = LottoStatistics.of(lottoTickets, winnerTicket);
        OutputView.printWinningStatistics(LottoStatisticsDto.from(lottoStatistics));

        LottoRevenueRate lottoRevenueRate = LottoRevenueRate.of(
                lottoStatistics.calculateTotalPrice(),
                lottoTicketCount.calculateTotalTicketMoney()
        );
        OutputView.printRevenueRate(lottoRevenueRate);
    }
}