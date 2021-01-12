package lotto;

import lotto.controller.LottoController;
import lotto.domain.number.RandomGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        LottoController lottoController = LottoController.of(new RandomGenerateStrategy(), inputMoney);
        OutputView.printTicketCount(inputMoney);

        while (lottoController.isTicketRemain()) {
            OutputView.printTicketNumbers(lottoController.gamePlay());
        }

        lottoController.setWinnerTicket(InputView.inputWinnerNumbers(), InputView.inputBonusNumber());

        OutputView.printWinningStatistics(lottoController.getRankingCountDto());

        OutputView.printRevenueRate(lottoController.getLottoRevenueRate());
    }

}
