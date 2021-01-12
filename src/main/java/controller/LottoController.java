package controller;

import domain.*;
import dto.Amount;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    public static void startLotto() {
        Amount amount = LottoInputView.inputAmount();


        LottoTicketCount manualCount = LottoInputView.inputManulCount(amount);
        LottoTicketCount autoCount = getAutoCount(manualCount, amount);

        LottoOutputView.printTicketsCount(manualCount, autoCount);

        NumberGenerateStrategy strategy = new LottoRandomGenerator();
        LottoTickets lottoTickets = LottoTickets.of(strategy, amount);
        LottoOutputView.printLottoTickets(lottoTickets.getLottoTickets());

        LottoWinningNumber lottoWinningNumber
                = LottoWinningNumber.of(LottoInputView.inputWinningNumbers(), LottoInputView.inputBonusNumber());

        WinningInfo winningInfo = new WinningInfo(lottoTickets, lottoWinningNumber);
        LottoOutputView.printResult(winningInfo.getWinningInfo());
        LottoOutputView.printYield(winningInfo.getYield(amount));
    }

    private static LottoTicketCount getAutoCount(LottoTicketCount manualCount, Amount amount) {
        return new LottoTicketCount(amount.getCount() - manualCount.getLottoTicketCount(), amount.getCount());
    }
}
