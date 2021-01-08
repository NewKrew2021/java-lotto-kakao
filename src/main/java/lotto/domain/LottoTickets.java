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
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoTickets)) {
            return false;
        }

        LottoTickets numbers = (LottoTickets) obj;
        if (getTicketsNum() != numbers.getTicketsNum()) {
            return false;
        }

        return this.tickets.containsAll(numbers.tickets);
    }
}
