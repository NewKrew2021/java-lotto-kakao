package lotto;

import lotto.domain.game.LottoGameCount;
import lotto.domain.game.LottoRevenue;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.number.RandomGenerateStrategy;
import lotto.domain.ranking.LottoRankingCount;
import lotto.view.InputView;
import lotto.view.LottoNumbersDto;
import lotto.view.LottoRankingCountDto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {

        LottoGameCount lottoGameCount = new LottoGameCount(InputView.inputMoney());
        OutputView.printTicketCount(lottoGameCount.getTicketCount());

        NumberGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        while (lottoGameCount.isTicketRemain()) {
            LottoNumbers lottoTicket = LottoNumbers.from(randomGenerateStrategy);
            lottoTickets.add(lottoTicket);
            lottoGameCount.useTicket();
            OutputView.printTicketNumbers(LottoNumbersDto.from(lottoTicket));
        }

        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinnerTicket winnerTicket = WinnerTicket.of(winnerNumbers, bonusNumber);

        LottoRankingCount lottoRankingCount = LottoRankingCount.of(lottoTickets, winnerTicket);
        OutputView.printWinningStatistics(LottoRankingCountDto.from(lottoRankingCount));

        double lottoRevenueRate = LottoRevenue.from(lottoRankingCount).calculateRevenueRate(lottoGameCount);
        OutputView.printRevenueRate(lottoRevenueRate);
    }
}