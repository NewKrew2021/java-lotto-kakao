package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.util.StringUtility;
import lotto.domain.WinnerNumber;
import lotto.view.LottoGameView;

import java.util.*;

public class LottoGame {
    private int price;
    private LottoTickets lottoTickets;
    private WinnerNumber winnerNumber;

    public void run() {
        requestPrice();
        makeAndPrintLottoTickets();
        makeWinnerNumber();
        makeAndPrintResult();
    }

    private void requestPrice() {
        price = LottoGameView.inputPrice();
    }

    private void makeAndPrintLottoTickets() {
        lottoTickets = LottoTickets.fromPrice(price);
        LottoGameView.printLottoTickets(lottoTickets);
    }

    private void makeWinnerNumber() {
        String input = LottoGameView.inputWinnerNumbers();
        int bonus = LottoGameView.inputBonusNumber();
        List<Integer> inputNumbers = StringUtility.StringToIntegerList(input);
        winnerNumber = WinnerNumber.from(inputNumbers, bonus);
    }

    private void makeAndPrintResult() {
        LottoResults lottoResults = lottoTickets.getResults(winnerNumber);
        LottoGameView.printResult(lottoResults, price);
    }

}
