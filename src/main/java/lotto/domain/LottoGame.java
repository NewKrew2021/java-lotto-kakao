package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private LottoTickets tickets;

    public boolean isAssignedTickets() {
        return this.tickets != null;
    }

    public void makeLottoTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = getLottoNumber();
            tickets.add(generateLottoTicket(numbers));
        }

        this.tickets = new LottoTickets(count, tickets);
    }

    private LottoNumbers getLottoNumber() {
        LottoNumberGenerator generator = new RandomNumberGenerator();
        LottoNumbers numbers = generator.generateNumbers();
        return numbers;
    }

    private LottoTicket generateLottoTicket(LottoNumbers numbers) {
        return new LottoTicket(numbers);
    }

    public int getLottoTicketCount(int money) {
        return money / TICKET_PRICE;
    }

}
