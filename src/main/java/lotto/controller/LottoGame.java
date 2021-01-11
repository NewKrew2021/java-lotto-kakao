package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.Price;
import lotto.domain.WinnerNumber;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

public class LottoGame {
    private Price price;
    private LottoTickets lottoTickets;
    private WinnerNumber winnerNumber;

    public void run() {
        requestPrice();
        makeAndPrintLottoTickets();
        makeWinnerNumber();
        makeAndPrintResult();
    }

    private void requestPrice() {
        LottoGameOutputView.askPrice();
        price = new Price(LottoGameInputView.inputPrice());
    }

    private void makeAndPrintLottoTickets() {
        lottoTickets = LottoTickets.fromPrice(price.getPrice());
        LottoGameOutputView.printLottoTickets(lottoTickets);
    }

    private void makeWinnerNumber() {
        LottoGameOutputView.askWinnerNumber();
        String inputNumbers = LottoGameInputView.inputWinnerNumbers();
        LottoGameOutputView.askBonusNumber();
        int bonus = LottoGameInputView.inputBonusNumber();
        winnerNumber = WinnerNumber.from(inputNumbers, bonus);
    }

    private void makeAndPrintResult() {
        LottoResults lottoResults = lottoTickets.getResults(winnerNumber);
        LottoGameOutputView.printResult(lottoResults, price.getPrice());
    }

}
