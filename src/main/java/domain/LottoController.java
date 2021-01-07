package domain;

import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {
    public static void startLotto() {
        Amount amount = new Amount(LottoInputView.inputAmount());
        int ticketCount = amount.getCount();
        LottoOutputView.printTicketsCount(ticketCount);

        LottoTickets lottoTickets = createLottoTickets(ticketCount);

        LottoTicket lottoWinningTicket = LottoTicket.ofLottoNumber(LottoInputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
        WinningInfo winningInfo = lottoTickets.getWinningInfo(lottoWinningNumber);
        LottoOutputView.printResult(winningInfo);
        LottoOutputView.printYield(amount, winningInfo.getSumPrize());
    }

    private static LottoTickets createLottoTickets(int ticketCount) {
        LottoTickets lottoTickets = LottoService.generateRandomLottoTickets(ticketCount);
        LottoOutputView.printTickets(lottoTickets.getLottoTicketsInfo());
        return lottoTickets;
    }


}
