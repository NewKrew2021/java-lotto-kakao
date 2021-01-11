package domain;

import dto.Amount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets of(NumberGenerateStrategy strategy, Amount amount) {
        int count = amount.getCount();
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(strategy.generate());
        }
        return new LottoTickets(tickets);
    }

    public List<List<Integer>> getLottoTickets() {
        return lottos.stream()
                .map(Lotto::getLottoTicketInfo)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos(){
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return this.lottos.size();
    }
}
