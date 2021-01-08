package lotto;

import lotto.domain.*;
import lotto.domain.dto.InsertPrice;
import lotto.domain.dto.WinningNumbers;
import lotto.utils.RandomPickStrategy;
import lotto.utils.TicketCountCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    private static int ticketCount;
    private static InputView inputView;
    private static OutputView outputView;
    private static LottoTickets tickets;
    private static WinningNumbers winningNumbers;
    private static MatchResults matchResults;
    private static InsertPrice insertPrice;

    public static void main(String[] args) {
        initializeIO();
        getUserInsertPrice();
        issueTicketsAndPrintAll();
        getWinningNumbers();

        matchUserTicketsToWinningTicket();
        printStatistics();
    }

    private static void initializeIO() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private static void getUserInsertPrice() {
        insertPrice = inputView.scanInsertPrice();
        ticketCount = TicketCountCalculator.getNumberOfTickets(insertPrice);
        outputView.printNumberOfLottoTickets(ticketCount);
    }

    private static void issueTicketsAndPrintAll() {
        tickets = LottoTicketIssuer.issue(new RandomPickStrategy(), ticketCount);
        outputView.printLottoTickets(tickets);
    }

    private static void getWinningNumbers() {
        winningNumbers = inputView.scanWinningNumbers();
    }

    private static void matchUserTicketsToWinningTicket() {
        matchResults = new LottoMatcher(winningNumbers).match(tickets);
    }

    private static void printStatistics() {
        outputView.printStatistics(new LottoStatistics(matchResults, insertPrice));
    }
}
