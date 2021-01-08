package controller;

import domain.LottoTickets;
import domain.Number;
import domain.WinnerNumber;
import view.LottoGameView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    public void run() {
        int price = priceProcess();
        LottoTickets tickets = ticketProcess(price);
        WinnerNumber winnerNumber = new WinnerNumber(
                winnerNumberProcess(),
                Number.getNumber(bonusProcess()));
        LottoGameView.result(tickets.getResults(winnerNumber).result(price));
    }

    private int priceProcess() {
        LottoGameView.startMessage();
        return LottoGameView.getInt();
    }

    private LottoTickets ticketProcess(int price) {
        LottoGameView.countTicket(price / TICKET_PRICE);
        LottoTickets tickets = new LottoTickets(price / TICKET_PRICE);
        LottoGameView.print(tickets.toString());
        return tickets;
    }

    private Set<Number> winnerNumberProcess() {
        LottoGameView.insertWinnerNumber();
        return Arrays.stream(LottoGameView.getStringLine()
                .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::getNumber).collect(Collectors.toSet());
    }

    private int bonusProcess() {
        LottoGameView.insertBonus();
        return LottoGameView.getInt();
    }
}
