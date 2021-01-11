package lotto.domain;

import java.util.*;

public class LottoTickets {
    private static final int TICKET_PRICE = 1_000;

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets fromPrice(int price) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < price / TICKET_PRICE; i++) {
            lottoTickets.add(new LottoTicket(new TreeSet<>(Number.randomNumbers(LottoTicket.BALL_COUNT))));
        }
        return new LottoTickets(lottoTickets);
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket).append('\n');
        }
        return stringBuilder.toString();
    }
}
