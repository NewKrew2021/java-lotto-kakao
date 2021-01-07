package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private NumberPool numberPool;

    public LottoTickets(int price) {
        numberPool = new NumberPool();
        lottoTickets = new ArrayList<>();
        lottoTickets = IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(numberPool.getRandomNumbers())))
                .collect(Collectors.toList());
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }
}
