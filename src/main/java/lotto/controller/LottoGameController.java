package lotto.controller;

import lotto.domain.game.LottoTicketCounts;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.LottoNumbersDto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoGameController(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public LottoTicketCounts getLottoTicketCounts() {
        return LottoTicketCounts.from(InputView.inputMoney(), InputView.inputManualTicketCount());
    }

    public List<LottoNumbers> buyLottoTickets(LottoTicketCounts lottoTicketCounts) {
        List<LottoNumbers> lottoTickets = new ArrayList<>();
        buyManualLottoTickets(lottoTicketCounts, lottoTickets);
        buyAutoLottoTickets(lottoTicketCounts, lottoTickets);
        return lottoTickets;
    }

    private void buyManualLottoTickets(LottoTicketCounts lottoTicketCounts, List<LottoNumbers> lottoTickets) {
        while (lottoTicketCounts.isManualTicketRemain()) {
            lottoTickets.add(LottoNumbers.from(InputView.inputLottoNumbers()));
            lottoTicketCounts.useManualTicket();
        }
    }

    private void buyAutoLottoTickets(LottoTicketCounts lottoTicketCounts, List<LottoNumbers> lottoTickets) {
        while (lottoTicketCounts.isAutoTicketRemain()) {
            LottoNumbers lottoTicket = LottoNumbers.from(numberGenerateStrategy);
            lottoTickets.add(lottoTicket);
            lottoTicketCounts.useAutoTicket();
            OutputView.printTicketNumbers(LottoNumbersDto.from(lottoTicket));
        }
    }

    public WinnerTicket getWinnerTicket() {
        return WinnerTicket.of(InputView.inputWinnerNumbers(), InputView.inputBonusNumber());
    }
}
