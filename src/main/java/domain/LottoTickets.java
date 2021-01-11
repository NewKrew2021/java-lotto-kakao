package domain;

import view.LottoGameView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private static final NumberPool numberPool = new NumberPool();

    private LottoTickets(List<LottoTicket> tickets) {
        lottoTickets = tickets;
    }

    public static LottoTickets of(int ticketCount) {
        return new LottoTickets(IntStream.rangeClosed(1, ticketCount)
                .mapToObj(val -> LottoTicket.ofSet(new HashSet<>(numberPool.getRandomNumbers())))
                .collect(Collectors.toList()));
    }

    public static LottoTickets ofList(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public static LottoTickets merge(LottoTickets a, LottoTickets b) {
        return new LottoTickets(Stream
                .concat(a.lottoTickets.stream(), b.lottoTickets.stream())
                .collect(Collectors.toList()));
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoResults getResults(WinnerNumber winnerNumber) {
        LottoResults lottoResults = new LottoResults();
        lottoTickets.stream()
                .map(ticket -> ticket.getRank(winnerNumber))
                .filter(Objects::nonNull)
                .forEach(lottoResults::updateOrInsert);
        return lottoResults;
    }

    public int size() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .reduce("", (total, s) -> total + s + "\n");
    }
}
