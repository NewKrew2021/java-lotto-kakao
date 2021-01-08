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

    public static void main(String[] argv){
        int price = InputView.inputPurchasePrice();

        setLottoTickets(price);
        WinningNumber winningNumber = setWinningNumber();

        ResultView.printResult(lottoTickets.getResults(winningNumber).result(price));

    }

    private static WinningNumber setWinningNumber() {
        Set<Number> winningNumber = Arrays.stream(InputView.winningNumber()
                .replaceAll(" ", "")
                .split(","))
                .map(Integer::valueOf)
                .map(Number::new)
                .collect(Collectors.toSet());;

        Number bonusNumber = new Number(InputView.bonusNumber());

        return new WinningNumber(winningNumber, bonusNumber);
    }

    private static void setLottoTickets(int price) {
        ResultView.purchaseLottoNumber(price);
        lottoTickets = new LottoTickets(price);
        ResultView.purchaseLottoTicket(lottoTickets);

    }
}
