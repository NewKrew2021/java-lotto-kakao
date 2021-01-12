package lotto;

import lotto.controller.LottoController;
import lotto.domain.number.ManualInputStrategy;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.number.RandomGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {

        NumberGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
        LottoController lottoController = new LottoController(InputView.inputMoney(), InputView.inputNumOfManualTickets());
        OutputView.printInputManualNumbers();

        while (lottoController.isManualTicketRemain()) {
            lottoController.makeTicketByStrategy(new ManualInputStrategy(InputView.inputManualNumbers()));
        }
        while (lottoController.isTicketRemain()) {
            lottoController.makeTicketByStrategy(randomGenerateStrategy);
        }

        OutputView.printTicketCount(lottoController.getNumOfManualTickets(), lottoController.getNumOfAutoTickets());
        OutputView.printAllTickets(lottoController);

        lottoController.setWinnerTicket(InputView.inputWinnerNumbers(), InputView.inputBonusNumber());

        OutputView.printWinningStatistics(lottoController.getRankingCountDto());

        OutputView.printRevenueRate(lottoController.getLottoRevenueRate());
    }

}
