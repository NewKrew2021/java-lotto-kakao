package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(int count, List<LottoTicket> tickets){
        isValid(count, tickets);
        this.tickets = tickets;
    }

    private void isValid(int count, List<LottoTicket> tickets) {
        if(tickets.size() != count)
            throw new IllegalArgumentException();
    }

}

