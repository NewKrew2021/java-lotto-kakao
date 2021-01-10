package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Number;

public class LottoGame {
    private static LottoTickets lottoTickets;
    private static WinningNumber winningNumber;

    public static void main(String[] argv){
        int price = InputView.inputPurchasePrice();

        setLottoTickets(price);
        winningNumber = new WinningNumber(InputView.winningNumber(), InputView.bonusNumber());

        ResultView.printResult(lottoTickets.getResults(winningNumber).result(price));

    }

    private static void setLottoTickets(int price) {
        ResultView.purchaseLottoNumber(price);
        lottoTickets = new LottoTickets(price);
        ResultView.purchaseLottoTicket(lottoTickets);

    }
}
