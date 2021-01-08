package lotto;

import lotto.domain.*;
import lotto.utils.RandomPickStrategy;
import lotto.utils.TicketCountCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    private static int ticketCount;
    private static LottoNumbers luckyNumber;
    private static LottoNumber bonusNumber;
    private static LottoTickets tickets;
    private static WinningNumbers winningNumbers;
    private static LottoMatcher lottoMatcher;
    private static MatchResults matchResults;
    private static LottoStatistics statistics;
    private static InsertPrice insertPrice;

    public static void main(String[] args) {
        getUserInsertPrice();
        issueTicketsAndPrintAll();
        getLuckyNumbersAndBonusNumber();

        matchUserTicketsToWinningTicket();
        printStatistics();
    }

    private static void getUserInsertPrice() {
        insertPrice = new InsertPrice(InputView.scanInsertPrice());
        ticketCount = TicketCountCalculator.getNumberOfTickets(insertPrice);
        OutputView.printNumberOfLottoTickets(ticketCount);
    }

    private static void issueTicketsAndPrintAll() {
        tickets = LottoTicketIssuer.issue(new RandomPickStrategy(), ticketCount);
        OutputView.printLottoTickets(tickets);
    }

    private static void getLuckyNumbersAndBonusNumber() {
        luckyNumber = InputView.scanLuckyNumber();
        bonusNumber = InputView.scanBonusNumber();
        winningNumbers = new WinningNumbers(luckyNumber, bonusNumber);
    }

    private static void matchUserTicketsToWinningTicket() {
        lottoMatcher = new LottoMatcher(winningNumbers);
        matchResults = lottoMatcher.match(tickets);
    }

    private static void printStatistics() {
        statistics = new LottoStatistics(matchResults, insertPrice);
        OutputView.printStatistics(statistics);
    }
}
