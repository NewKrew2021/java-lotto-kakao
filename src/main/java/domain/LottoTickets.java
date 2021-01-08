package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private final NumberPool numberPool;

    public LottoTickets(int ticketCount) {
        numberPool = new NumberPool();
        lottoTickets = IntStream.rangeClosed(1, ticketCount)
                .mapToObj(val -> new LottoTicket(new HashSet<>(numberPool.getRandomNumbers())))
                .collect(Collectors.toList());
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoResults getResults(WinnerNumber winnerNumber) {
        LottoResults lottoResults = new LottoResults();
        lottoTickets.stream()
                .map(ticket->ticket.getRank(winnerNumber))
                .filter(Objects::nonNull)
                .forEach(lottoResults::updateOrInsert);
        return lottoResults;
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .reduce("", (total, s) -> total + s + "\n");
    }
}
