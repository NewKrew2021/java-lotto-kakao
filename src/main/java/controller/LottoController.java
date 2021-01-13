package controller;

import domain.Amount;
import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoTicketCount;
import domain.LottoTicketGenerator;
import domain.LottoTickets;
import domain.LottoWinningNumber;
import domain.WinningInfo;
import java.util.List;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {

  public static void startLotto() {
    Amount amount = new Amount(LottoInputView.inputAmount());

    LottoTicketCount lottoTicketCount = new LottoTicketCount(amount,
        LottoInputView.inputManualCount());

    LottoTickets lottoTickets = createLottoTickets(lottoTicketCount);
    LottoOutputView.printTicketsCount(lottoTicketCount);

    LottoTicket lottoWinningTicket = LottoTicket.of(LottoInputView.inputWinningNumbers());
    LottoNumber bonusNumber = LottoNumber.of(LottoInputView.inputBonusNumber());

    LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
    WinningInfo winningInfo = lottoTickets.getWinningInfo(lottoWinningNumber);
    LottoOutputView.printResult(winningInfo);
    LottoOutputView.printYield(winningInfo.getYield(amount));
  }

  private static LottoTickets createLottoTickets(LottoTicketCount lottoTicketCount) {
    List<String> manualLottoNumbers = LottoInputView
        .inputManualLottoNumbers(lottoTicketCount.getManualCount());
    LottoTickets lottoTickets = LottoTicketGenerator
        .generateLottoTickets(manualLottoNumbers, lottoTicketCount.getAutoCount());
    LottoOutputView.printTickets(lottoTickets.getLottoTicketsInfo());
    return lottoTickets;
  }


}
