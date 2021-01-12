package domain;

import dto.Amount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets of(NumberGenerateStrategy strategy, Amount amount) {
        int count = amount.getCount();
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(Lotto.from(strategy));
        }
        return new LottoTickets(tickets);
    }

    public static LottoTickets from(List<List<Integer>> lottoNumbers){
        List<Lotto> tickets = new ArrayList<>();
        for (List<Integer> lottoNumber : lottoNumbers) {
            tickets.add(Lotto.from(lottoNumber
                    .stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toSet())));
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

    public LottoTickets concat(LottoTickets autoTickets) {
        return new LottoTickets(Stream
                .concat(lottos.stream(), autoTickets.getLottos().stream())
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets tickets = (LottoTickets) o;
        return Objects.equals(lottos, tickets.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
