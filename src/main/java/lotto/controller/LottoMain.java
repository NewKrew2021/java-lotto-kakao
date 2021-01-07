package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoGame;

public class LottoMain {
    public static void main(String[] args){
        int money = InputView.getMoneyFromUser();
        LottoGame game = new LottoGame();
        int count = game.getLottoTicketCount(money);
        game.makeLottoTickets(count);
        OutputView.printLottoTicketCount(count);
    }
}
