package controller;

import domain.*;
import dto.Amount;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    public static void startLotto() {
        Amount amount = new Amount(LottoInputView.inputAmount());
        LottoOutputView.printTicketsCount(amount);

        LottoTickets lottoTickets = LottoService.generateTickets(amount);
        LottoOutputView.printLottoTickets(lottoTickets.getLottoTickets());

        LottoWinningNumber lottoWinningNumber
                = LottoWinningNumber.of(LottoInputView.inputWinningNumbers(), LottoInputView.inputBonusNumber());

        WinningInfo winningInfo = lottoTickets.getWinningInfo(lottoWinningNumber);
        LottoOutputView.printResult(winningInfo);
        LottoOutputView.printYield(amount, winningInfo.getSum());
    }
}
