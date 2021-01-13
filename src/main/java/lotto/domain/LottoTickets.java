package lotto.domain;

import lotto.domain.dto.LottoTicketsDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public MatchResults matchWinning(WinningNumbers winningNumbers) {
        return new MatchResults(tickets.stream()
                .map(ticket -> ticket.matchWinning(winningNumbers))
                .collect(Collectors.toList()));
    }

    public LottoTicketsDto getAllTicketNumbers() {
        return new LottoTicketsDto(tickets.stream()
                .map(LottoNumbers::getNumbersInTicket)
                .collect(Collectors.toList()));
    }

    public LottoTickets join(LottoTickets source) {
        return new LottoTickets(Stream.of(tickets, source.tickets)
                .flatMap(List::stream)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return (tickets.size() == that.tickets.size()) && this.tickets.containsAll(that.tickets);
    }
}
