package lotto.controller;

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

public class LottoGameController {

    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoGameController(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public LottoTicketCount getLottoTicketCount() {
        LottoTicketCount lottoTicketCount = new LottoTicketCount(InputView.inputMoney());
        OutputView.printTicketCount(lottoTicketCount);
        return lottoTicketCount;
    }

    public List<LottoNumbers> buyLottoTickets(LottoTicketCount lottoTicketCount) {
        List<LottoNumbers> lottoTickets = new ArrayList<>();
        while (lottoTicketCount.isTicketRemain()) {
            LottoNumbers lottoTicket = LottoNumbers.from(numberGenerateStrategy);
            lottoTickets.add(lottoTicket);
            lottoTicketCount.useTicket();
            OutputView.printTicketNumbers(LottoNumbersDto.from(lottoTicket));
        }
        return lottoTickets;
    }

    public WinnerTicket getWinnerTicket() {
        return WinnerTicket.of(InputView.inputWinnerNumbers(), InputView.inputBonusNumber());
    }
}
