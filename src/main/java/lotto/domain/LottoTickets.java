package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(int count, List<LottoNumbers> tickets){
        isValid(count, tickets);
        this.tickets = tickets;
    }

    private void isValid(int count, List<LottoNumbers> tickets) {
        if(tickets.size() != count)
            throw new IllegalArgumentException();
    }

}

