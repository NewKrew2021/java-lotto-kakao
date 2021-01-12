package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getMoneyFromUser();
        LottoGame game = new LottoGame();

        int totalCount = game.getLottoTicketCount(money);
        int manualCount = InputView.getMaualLottoCount(totalCount);
        List<List<Integer>> manualLottoNumbers = InputView.getMaualLottoNumbers(manualCount);

        LottoTickets lottoTickets = game.makeLottoTickets(totalCount, manualLottoNumbers);
        OutputView.printLottoTicketCount(totalCount, manualCount);
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
