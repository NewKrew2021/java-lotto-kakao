package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final int count;
    private final List<LottoTicket> tickets;

    public LottoTickets(int count){
        this.count = count;
        tickets = new ArrayList<LottoTicket>();
    }

    public void generateTickets(LottoNumbers[] numbers){
        for (LottoNumbers number : numbers) {
            tickets.add(new LottoTicket(number));
        }
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

}

