package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public int getTicketsNum() {
        return tickets.size();
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return (getTicketsNum() == that.getTicketsNum()) && this.tickets.containsAll(that.tickets);
    }
}
