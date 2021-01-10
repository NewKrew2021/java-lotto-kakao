package lotto.domain;

import lotto.domain.dto.InsertPrice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoTicketIssuer {
    public static final int TICKET_PRICE = 1000;
    private final InsertPrice insertPrice;

    public LottoTicketIssuer(InsertPrice insertPrice) {
        this.insertPrice = insertPrice;
    }

    public LottoTickets issue(NumberPickStrategy strategy) {
        return new LottoTickets(IntStream.range(0, getTicketCount())
                .boxed()
                .map(ignore -> new LottoNumbers(strategy.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }

    public int getInvestedMoney() {
        return getTicketCount() * TICKET_PRICE;
    }

    public int getChange() {
        return insertPrice.getPrice() % 1000;
    }

    public int getTicketCount() {
        return insertPrice.getPrice() / LottoTicketIssuer.TICKET_PRICE;
    }
}
