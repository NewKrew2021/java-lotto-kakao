package controller;

import domain.LottoTicket;
import domain.LottoTickets;
import domain.Number;
import domain.WinnerNumber;
import exception.InvalidPriceException;
import view.LottoGameView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    public void run() {
        int totalPrice = priceProcess();
        LottoTickets manualTickets = manualTicketProcess(totalPrice);
        LottoTickets autoTickets = ticketProcess(totalPrice - TICKET_PRICE * manualTickets.size());
        LottoTickets tickets = LottoTickets.merge(manualTickets, autoTickets);
        LottoGameView.ticketCount(manualTickets.size(), autoTickets.size());
        LottoGameView.print(tickets.toString());
        WinnerNumber winnerNumber = new WinnerNumber(
                winnerNumberProcess(),
                Number.from(bonusProcess()));
        LottoGameView.result(tickets.getResults(winnerNumber).result(totalPrice));
    }

    private int priceProcess() {
        LottoGameView.startMessage();
        return LottoGameView.getInt();
    }

    private LottoTickets manualTicketProcess(int price) {
        LottoGameView.insertLotto();
        int ticketCount = LottoGameView.getInt();
        if (TICKET_PRICE * ticketCount > price) {
            throw new InvalidPriceException(price);
        }
        LottoGameView.insertLottoNumbers();
        return LottoTickets.ofList(IntStream.rangeClosed(1, ticketCount)
                .mapToObj(val -> LottoTicket.of(LottoGameView.getStringLine()))
                .collect(Collectors.toList()));
    }

    private LottoTickets ticketProcess(int price) {
        return LottoTickets.of(price / TICKET_PRICE);
    }

    private Set<Number> winnerNumberProcess() {
        LottoGameView.insertWinnerNumber();
        return Arrays.stream(LottoGameView.getStringLine()
                .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::from).collect(Collectors.toSet());
    }

    private int bonusProcess() {
        LottoGameView.insertBonus();
        return LottoGameView.getInt();
    }
}
