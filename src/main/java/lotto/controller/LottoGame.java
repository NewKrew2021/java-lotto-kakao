package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.Price;
import lotto.util.StringUtility;
import lotto.domain.WinnerNumber;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

import java.util.*;

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
        price = new Price(LottoGameInputView.inputPrice());
    }

    private void makeAndPrintLottoTickets() {
        lottoTickets = LottoTickets.fromPrice(price.getPrice());
        LottoGameOutputView.printLottoTickets(lottoTickets);
    }

    private void makeWinnerNumber() {
        String input = LottoGameInputView.inputWinnerNumbers();
        int bonus = LottoGameInputView.inputBonusNumber();
        List<Integer> inputNumbers = StringUtility.StringToIntegerList(input);
        winnerNumber = WinnerNumber.from(inputNumbers, bonus);
    }

    private void makeAndPrintResult() {
        LottoResults lottoResults = lottoTickets.getResults(winnerNumber);
        LottoGameOutputView.printResult(lottoResults, price.getPrice());
    }

}
