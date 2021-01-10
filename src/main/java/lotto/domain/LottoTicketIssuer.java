package lotto.domain;

import lotto.domain.dto.InsertPrice;

import java.util.ArrayList;
import java.util.List;

public final class LottoTicketIssuer {
    public static final int TICKET_PRICE = 1000;
    private final InsertPrice insertPrice;

    public LottoTicketIssuer(InsertPrice insertPrice) {
        this.insertPrice = insertPrice;
    }

    public LottoTickets issue(NumberPickStrategy strategy) {
        List<LottoNumbers> numbers = new ArrayList<>();

        for (int ignored = 0; ignored < getTicketCount(); ignored++) {
            numbers.add(new LottoNumbers(strategy.generateLottoNumbers()));
        }

        return new LottoTickets(numbers);
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
