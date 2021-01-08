package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public void delegate(Consumer<List<LottoNumbers>> consumer) {
        consumer.accept(tickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return (tickets.size() == that.tickets.size()) && this.tickets.containsAll(that.tickets);
    }
}
