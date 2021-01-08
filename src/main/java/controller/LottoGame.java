package controller;

import domain.LottoTickets;
import domain.Number;
import domain.WinnerNumber;
import view.LottoGameView;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private static final Scanner sc = new Scanner(System.in);

    public void run() {
        int price = priceProcess();
        LottoTickets tickets = ticketProcess(price);
        WinnerNumber winnerNumber = new WinnerNumber(
                winnerNumberProcess(),
                new Number(bonusProcess()));
        LottoGameView.result(tickets.getResults(winnerNumber).result(price));
    }

    private int priceProcess() {
        LottoGameView.startMessage();
        return LottoGameView.getPrice();
    }

    private LottoTickets ticketProcess(int price) {
        LottoGameView.countTicket(price / TICKET_PRICE);
        LottoTickets tickets = new LottoTickets(price / TICKET_PRICE);
        LottoGameView.print(tickets.toString());
        return tickets;
    }

    private Set<Number> winnerNumberProcess() {
        LottoGameView.insertWinnerNumber();
        return Arrays.stream(sc.nextLine()
                .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::new).collect(Collectors.toSet());
    }

    private int bonusProcess() {
        LottoGameView.insertBonus();
        return sc.nextInt();
    }
}
