package lotto.controller;

import lotto.domain.*;
import lotto.domain.vo.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void play() {
        Buyer buyer;
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Price insertPrice = inputView.scanPrice();
        int manualChoose = inputView.scanManualChooseTicketCount();
        buyer = new Buyer(insertPrice, manualChoose);

        LottoTickets manualTickets = inputView.scanManualChooseTickets(buyer.getManualChooseTicketAmount());
        LottoTickets randomTickets = LottoTicketIssuer.issue(
                new RandomPickStrategy(), buyer.getRandomChooseTicketAmount());
        buyer.setLottoTickets(manualTickets.join(randomTickets));

        outputView.printChangeIfExists(buyer.getChange());
        outputView.printNumberOfLottoTickets(buyer.getManualChooseTicketAmount(), buyer.getRandomChooseTicketAmount());
        outputView.printLottoTickets(buyer.getLottoTickets());

        MatchResults matchResults = new LottoMatcher(inputView.scanWinningNumbers()).match(buyer.getLottoTickets());
        outputView.printStatistics(new LottoStatistics(matchResults, buyer.getInvestedMoney()));
    }
}
