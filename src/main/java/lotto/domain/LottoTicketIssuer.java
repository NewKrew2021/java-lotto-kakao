package lotto.domain;

import lotto.domain.vo.Price;

import java.util.ArrayList;
import java.util.List;

public final class LottoTicketIssuer {
    public static final int TICKET_PRICE = 1000;
    private final Price price;

    public LottoTicketIssuer(Price price) {
        this.price = price;
    }

    public LottoTickets issue(NumberPickStrategy strategy) {
        List<LottoNumbers> numbers = new ArrayList<>();

        for (int ignored = 0; ignored < getTicketCount(); ignored++) {
            numbers.add(new LottoNumbers(strategy.generateLottoNumbers()));
        }

        return new LottoTickets(numbers);
    }

    public long getInvestedMoney() {
        return getTicketCount() * TICKET_PRICE;
    }

    public long getChange() {
        return price.getPrice() % 1000;
    }

    public long getTicketCount() {
        return price.getPrice() / LottoTicketIssuer.TICKET_PRICE;
    }
}
