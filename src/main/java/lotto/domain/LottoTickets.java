package lotto.domain;

import lotto.domain.strategy.TicketStrategy;

import java.util.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets from(TicketStrategy strategy, int count) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(LottoTicket.from(strategy));
        }
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets join(LottoTickets manualTickets, LottoTickets autoTickets) {
        List<LottoTicket> joinedTickets = new ArrayList<>();
        joinedTickets.addAll(manualTickets.lottoTickets);
        joinedTickets.addAll(autoTickets.lottoTickets);
        return new LottoTickets(joinedTickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoResults getResults(WinnerNumber winnerNumber) {
        LottoResults lottoResults = new LottoResults();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoResults.upsert(winnerNumber.getRank(lottoTicket));
        }
        return lottoResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket).append('\n');
        }
        return stringBuilder.toString();
    }
}
