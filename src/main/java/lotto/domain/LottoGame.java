package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private LottoTickets tickets;
    private LottoStat statistics;

    public boolean isAssignedTickets() {
        return this.tickets != null;
    }

    public LottoTickets makeLottoTickets(int count) {
        List<LottoNumbers> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Set<Integer> numbers = getLottoNumber();
            tickets.add(generateLottoTicket(numbers));
        }

        this.tickets = new LottoTickets(count, tickets);
        return this.tickets;
    }

    private Set<Integer> getLottoNumber() {
        LottoNumberGenerator generator = new RandomNumberGenerator();
        Set<Integer> numbers = generator.generateNumbers();
        return numbers;
    }

    private LottoNumbers generateLottoTicket(Set<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public int getLottoTicketCount(int money) {
        return money / TICKET_PRICE;
    }

    public LottoStat getStatistics(WinnerNumbers winner) {
        this.statistics = tickets.calculateLottoStatistics(winner);
        return this.statistics;
    }

    public float getEarningRatio(){
        long reward = statistics.getReward();
        int count = tickets.getTicketsCount();

        return (float)reward / (float)(TICKET_PRICE * count);
    }
}
