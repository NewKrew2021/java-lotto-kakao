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

        LottoTickets manualTickets = LottoTickets.from(LottoInputView.inputLottoNumbers(manualCount));
        LottoOutputView.printTicketsCount(manualCount, autoCount);

        LottoTickets autoTickets = LottoTickets.of(new LottoRandomGenerator(), amount);
        LottoTickets lottoTickets = manualTickets.concat(autoTickets);

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
