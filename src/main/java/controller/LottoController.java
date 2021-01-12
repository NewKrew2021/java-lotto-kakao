package controller;

import domain.*;
import dto.Amount;
import dto.LottoTicketCount;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    public static void startLotto() {
        Amount amount = LottoInputView.inputAmount();

        LottoTicketCount ticketCount = LottoInputView.inputManualCount(amount);

        LottoTickets lottoTickets
                = LottoTicketsFactory.newManualAndAuto(ticketCount, LottoInputView.inputLottoNumbers(ticketCount));

        LottoOutputView.printLottoTickets(ticketCount, lottoTickets.getLottoTickets());

        LottoWinningNumber lottoWinningNumber
                = LottoWinningNumber.of(LottoInputView.inputWinningNumbers(), LottoInputView.inputBonusNumber());

        WinningInfo winningInfo = new WinningInfo(lottoTickets, lottoWinningNumber);
        LottoOutputView.printResult(winningInfo.getWinningInfo());
        LottoOutputView.printYield(winningInfo.getYield(amount));
    }
}
