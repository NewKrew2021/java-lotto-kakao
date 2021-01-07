package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private final NumberPool numberPool;

    public LottoTickets(int price) {
        numberPool = new NumberPool();
        lottoTickets = new ArrayList<>();
        lottoTickets = IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(numberPool.getRandomNumbers())))
                .collect(Collectors.toList());
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoResults getResults(WinnerNumber winnerNumber) {
        LottoResults lottoResults = new LottoResults();
        lottoTickets.stream()
                .filter(ticket->ticket.getRank(winnerNumber)!=null)
                .forEach(ticket->lottoResults.upsert(ticket.getRank(winnerNumber)));
        return lottoResults;
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .reduce("", (total, s) -> total + s + "\n");
    }
}
