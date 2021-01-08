package lotto.utils;

import lotto.domain.InsertPrice;
import lotto.domain.LottoTicketIssuer;

public class TicketCountCalculator {
    public static int getNumberOfTickets(InsertPrice insertPrice) {
        return insertPrice.getPrice() / LottoTicketIssuer.TICKET_PRICE;
    }
}
