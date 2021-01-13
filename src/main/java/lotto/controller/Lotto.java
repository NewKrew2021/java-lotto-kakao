package lotto.controller;

import lotto.domain.*;
import lotto.domain.vo.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void play() {
        TicketBuyer ticketBuyer;
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Price insertPrice = inputView.scanPrice();
        int manualChoose = inputView.scanManualCount();
        ticketBuyer = new TicketBuyer(insertPrice, manualChoose);

        LottoTickets manualTickets = TicketSeller.issuing(
                new ManualPickStrategy(inputView.scanManualTickets(ticketBuyer.getManualCount())),
                ticketBuyer.getManualCount());
        LottoTickets randomTickets = TicketSeller.issuing(
                new RandomPickStrategy(),
                ticketBuyer.getRandomCount());
        ticketBuyer.issueTickets(manualTickets.join(randomTickets));

        outputView.printChangeIfExists(ticketBuyer.getChange());
        outputView.printNumberOfLottoTickets(ticketBuyer.getManualCount(), ticketBuyer.getRandomCount());
        outputView.printLottoTickets(ticketBuyer.getLottoTickets());

        MatchResults matchResults = new LottoMatcher(inputView.scanWinningNumbers()).match(ticketBuyer.getLottoTickets());
        outputView.printStatistics(new LottoStatistics(matchResults, ticketBuyer.getInvestedMoney()));
    }
}
