package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.CreateTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    public static void main(String[] argv) {
        int[] purchaseInfo = InputView.inputPurchaseInfo();

        LottoTickets lottoTickets = new LottoTickets(CreateTicket.createTotalTicket(purchaseInfo[0],
                IntStream.rangeClosed(1, purchaseInfo[1])
                        .mapToObj(val -> InputView.inputHandLottoNumber())
                        .collect(Collectors.toList())));

        ResultView.purchaseLottoTicket(lottoTickets);

        WinningNumber winningNumber = new WinningNumber(InputView.winningNumber(), InputView.bonusNumber());
        ResultView.printResult(lottoTickets.getResults(winningNumber), purchaseInfo[0]);
    }
}

