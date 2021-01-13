package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private LottoTickets tickets;
    private LottoStatistics statistics;

    public LottoTickets makeLottoTickets(int totalCount, List<List<Integer>> manualLottoNumbers) {
        List<LottoNumbers> tickets = makeManualLottoTickets(manualLottoNumbers);
        
        for (int i = 0; i < totalCount - manualLottoNumbers.size(); i++) {
            Set<Integer> numbers = getLottoNumber();
            tickets.add(toLottoNumbers(numbers));
        }

        this.tickets = new LottoTickets(tickets);
        return this.tickets;
    }

    private Set<Integer> getLottoNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        return generator.generateNumbers();
    }

    private LottoNumbers toLottoNumbers(Set<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public int getLottoTicketCount(int money) {
        return money / TICKET_PRICE;
    }

    public LottoStatistics getStatistics(WinnerNumbers winner) {
        this.statistics = tickets.calculateLottoStatistics(winner);
        return this.statistics;
    }

    public float getEarningRatio() {
        long reward = statistics.getReward();
        int count = getTicketsCount();

        return (float) reward / (float) (TICKET_PRICE * count);
    }

    public int getTicketsCount(){
        return tickets.getTicketsCount();
    }

    public void setTickets(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public List<LottoNumbers> makeManualLottoTickets(List<List<Integer>> manualLottoNumbers) {
        List<LottoNumbers> tickets = new ArrayList<>();
        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            Set<Integer> numbers = new HashSet<>(manualLottoNumber);
            tickets.add(toLottoNumbers(numbers));
        }

        return tickets;
    }
}
