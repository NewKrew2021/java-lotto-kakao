package lotto;

import lotto.domain.*;
import lotto.domain.dto.InsertPrice;
import lotto.utils.RandomPickStrategy;
import lotto.utils.TicketCountCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    private static int ticketCount;
    private static InputView inputView;
    private static OutputView outputView;
    private static LottoNumbers luckyNumber;
    private static LottoNumber bonusNumber;
    private static LottoTickets tickets;
    private static WinningNumbers winningNumbers;
    private static LottoMatcher lottoMatcher;
    private static MatchResults matchResults;
    private static LottoStatistics statistics;
    private static InsertPrice insertPrice;

    public static void main(String[] args) {
        initializeIO();
        getUserInsertPrice();
        issueTicketsAndPrintAll();
        getLuckyNumbersAndBonusNumber();

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

    private static void getLuckyNumbersAndBonusNumber() {
        luckyNumber = inputView.scanLuckyNumber();
        bonusNumber = inputView.scanBonusNumber();
        winningNumbers = new WinningNumbers(luckyNumber, bonusNumber);
    }

    private static void matchUserTicketsToWinningTicket() {
        lottoMatcher = new LottoMatcher(winningNumbers);
        matchResults = lottoMatcher.match(tickets);
    }

    private static void printStatistics() {
        statistics = new LottoStatistics(matchResults, insertPrice);
        outputView.printStatistics(statistics);
    }
}
