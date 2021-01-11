package lotto;

import lotto.controller.LottoGameController;
import lotto.controller.LottoStatisticsController;
import lotto.domain.game.LottoTicketCount;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.RandomLottoNumberGenerator;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new RandomLottoNumberGenerator());
        LottoStatisticsController lottoStatisticsController = new LottoStatisticsController();

        LottoTicketCount lottoTicketCount = lottoGameController.getLottoTicketCount();
        List<LottoNumbers> lottoTickets = lottoGameController.buyLottoTickets(lottoTicketCount);
        WinnerTicket winnerTicket = lottoGameController.getWinnerTicket();

        lottoStatisticsController.calculateLottoResult(lottoTickets, winnerTicket);
    }
}