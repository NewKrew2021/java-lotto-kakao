package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.CreateTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;


public class LottoGame {
    public static void main(String[] argv) {
        int price = InputView.inputPurchasePrice();
        List<String> handLotto = InputView.inputHandLotto(price);
        LottoTickets lottoTickets = new LottoTickets(CreateTicket.createTotalTicket(price, handLotto));

        ResultView.purchaseLottoTicket(lottoTickets, handLotto);

        WinningNumber winningNumber = new WinningNumber(InputView.winningNumber(), InputView.bonusNumber());
        ResultView.printResult(lottoTickets.getResults(winningNumber), price);
    }
}

