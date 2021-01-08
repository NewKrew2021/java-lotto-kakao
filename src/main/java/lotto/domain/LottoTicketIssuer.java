package lotto.domain;

import lotto.utils.NumberPickStrategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoTicketIssuer {
    public static final int TICKET_PRICE = 1000;

    private LottoTicketIssuer() {
        String message = String.format("Static util class(%s) should not be instantiated", this.getClass());
        throw new IllegalStateException(message);
    }

    public static LottoTickets issue(NumberPickStrategy strategy, int ticketCount) {
        return new LottoTickets(IntStream.range(0, ticketCount)
                .boxed()
                .map(ignore -> new LottoNumbers(strategy.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }
}
