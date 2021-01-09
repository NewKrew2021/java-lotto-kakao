package lotto.controller;

import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.ranking.LottoStatistics;
import lotto.view.LottoStatisticsDto;
import lotto.view.OutputView;

import java.util.List;

public class LottoStatisticsController {

    public void calculateLottoResult(List<LottoNumbers> lottoTickets, WinnerTicket winnerTicket) {
        LottoStatistics lottoStatistics = LottoStatistics.of(lottoTickets, winnerTicket);
        OutputView.printWinningStatistics(LottoStatisticsDto.from(lottoStatistics));
        OutputView.printRevenueRate(lottoStatistics.calculateRevenueRate());
    }
}
