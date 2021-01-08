package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private LottoNumber numberPool;

    public LottoTickets(int price) {
        numberPool = new LottoNumber();
        lottoTickets = new ArrayList<>();
        lottoTickets = IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(numberPool.getRandomNumbers())))
                .collect(Collectors.toList());
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
}
