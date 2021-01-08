package domain.controller;

import domain.*;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    public static void startLotto() {
        Amount amount = new Amount(LottoInputView.inputAmount());
        int ticketsCount = amount.getCount();
        LottoOutputView.printTicketsCount(ticketsCount);

        LottoTickets lottoTickets = LottoService.generateTickets(amount);
        LottoOutputView.printLottoTickets(lottoTickets.getLottoTickets());

        LottoTicket lottoWinningTicket = LottoTicket.ofLottoNumber(LottoInputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);

        WinningInfo winningInfo = lottoTickets.getWinningInfo(lottoWinningNumber);
        LottoOutputView.printResult(winningInfo);
        LottoOutputView.printYield(amount, winningInfo.getSum());
    }
}
