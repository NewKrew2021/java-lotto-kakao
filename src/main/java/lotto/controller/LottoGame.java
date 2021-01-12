package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseInformation;
import lotto.domain.WinnerNumber;
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
        List<String> rawManualNumbers = LottoGameInputView.inputManualTickets(purchase.getManualCount());
        lottoTickets = LottoTickets.from(purchase, rawManualNumbers);
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
        LottoGameOutputView.printResult(lottoResults, purchase.getPrice());
    }

}
