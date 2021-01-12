package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseInformation;
import lotto.domain.WinnerNumber;
import lotto.domain.strategy.ManualTicketStrategy;
import lotto.domain.strategy.RandomTicketStrategy;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

import java.util.List;

public class LottoGame {
    private PurchaseInformation purchase;
    private LottoTickets lottoTickets;
    private WinnerNumber winnerNumber;

    public void run() {
        requestPurchaseInformation();
        makeAndPrintLottoTickets();
        makeWinnerNumber();
        makeAndPrintResult();
    }

    private void requestPurchaseInformation() {
        purchase = new PurchaseInformation(LottoGameInputView.inputPrice(), LottoGameInputView.inputManualTicketCount());
    }

    private void makeAndPrintLottoTickets() {
        LottoGameOutputView.printManualSentence();
        LottoTickets manualTickets = LottoTickets.from(new ManualTicketStrategy(), purchase.getManualCount());
        LottoTickets autoTickets = LottoTickets.from(new RandomTicketStrategy(), purchase.getAutoCount());
        lottoTickets = LottoTickets.join(manualTickets, autoTickets);
        LottoGameOutputView.printTicketCount(purchase);
        LottoGameOutputView.printLottoTickets(lottoTickets);
    }

    private void makeWinnerNumber() {
        String inputNumbers = LottoGameInputView.inputWinnerNumbers();
        int bonus = LottoGameInputView.inputBonusNumber();
        winnerNumber = WinnerNumber.from(inputNumbers, bonus);
    }

    private void makeAndPrintResult() {
        LottoResults lottoResults = lottoTickets.getResults(winnerNumber);
        LottoGameOutputView.printResult(lottoResults);
    }

}
