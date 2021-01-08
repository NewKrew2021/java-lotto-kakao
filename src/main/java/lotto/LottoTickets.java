package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets fromPrice(int price) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            lottoTickets.add(new LottoTicket(new TreeSet<>(NumberPool.getInstance().getRandomNumbers())));
        }
        return new LottoTickets(lottoTickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoResults getResults(WinnerNumber winnerNumber) {
        LottoResults lottoResults = new LottoResults();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoResults.upsert(lottoTicket.getRank(winnerNumber));
        }
        return lottoResults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            sb.append(lottoTicket).append('\n');
        }
        return sb.toString();
    }
}
