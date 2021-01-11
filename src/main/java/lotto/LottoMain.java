package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getMoneyFromUser();
        LottoGame game = new LottoGame();

        int count = game.getLottoTicketCount(money);
        OutputView.printLottoTicketCount(count);
        LottoTickets lottoTickets = game.makeLottoTickets(count);
        OutputView.printLottoTickets(lottoTickets);

        Set<Integer> numbers = InputView.getWinnerNumber();
        int bonusBall = InputView.getBonusBall();
        WinnerNumbers winnerNumbers = new WinnerNumbers(numbers, bonusBall);
        LottoStatistics lottoStatistics = game.getStatistics(winnerNumbers);
        OutputView.printLottoStatistics(lottoStatistics);

        float earningRatio = game.getEarningRatio();
        OutputView.printEarningRatio(earningRatio);
    }
}
