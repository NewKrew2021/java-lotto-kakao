package lotto.controller;

import lotto.domain.*;
import lotto.domain.RandomPickStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void play() {
        LottoTicketIssuer issuer;
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        issuer = new LottoTicketIssuer(inputView.scanInsertPrice());
        LottoTickets tickets = issuer.issue(new RandomPickStrategy());

        outputView.printNumberOfLottoTickets(issuer.getTicketCount(), issuer.getChange());
        outputView.printLottoTickets(tickets);

        MatchResults matchResults = new LottoMatcher(inputView.scanWinningNumbers()).match(tickets);
        outputView.printStatistics(new LottoStatistics(matchResults, issuer.getInvestedMoney()));
    }
}
