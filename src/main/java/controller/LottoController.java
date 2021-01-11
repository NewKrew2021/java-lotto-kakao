package controller;

import domain.Amount;
import domain.LottoNumber;
import domain.LottoService;
import domain.LottoTicket;
import domain.LottoTickets;
import domain.LottoWinningNumber;
import domain.WinningInfo;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {

  public static void startLotto() {
    Amount amount = new Amount(LottoInputView.inputAmount());
    int ticketCount = amount.getCount();
    LottoOutputView.printTicketsCount(ticketCount);

    LottoTickets lottoTickets = createLottoTickets(ticketCount);

    LottoTicket lottoWinningTicket = new LottoTicket(LottoInputView.inputWinningNumbers());
    LottoNumber bonusNumber = LottoNumber.of(LottoInputView.inputBonusNumber());

    LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
    WinningInfo winningInfo = lottoTickets.getWinningInfo(lottoWinningNumber);
    LottoOutputView.printResult(winningInfo);
    LottoOutputView.printYield(winningInfo.getYield(amount));
  }

  private static LottoTickets createLottoTickets(int ticketCount) {
    LottoTickets lottoTickets = LottoService.generateRandomLottoTickets(ticketCount);
    LottoOutputView.printTickets(lottoTickets.getLottoTicketsInfo());
    return lottoTickets;
  }


}
