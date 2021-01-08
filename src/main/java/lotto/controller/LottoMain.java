package lotto.controller;

import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoGame;

import java.util.Set;

public class LottoMain {
    public static void main(String[] args){
        int money = InputView.getMoneyFromUser();
        LottoGame game = new LottoGame();
        int count = game.getLottoTicketCount(money);
        game.makeLottoTickets(count);
        OutputView.printLottoTicketCount(count);
        Set<Integer> numbers = InputView.getWinnerNumber();
        int bonusBall = InputView.getBonusBall();
        WinnerNumbers winnerNumbers = new WinnerNumbers(numbers, bonusBall);
    }
}
