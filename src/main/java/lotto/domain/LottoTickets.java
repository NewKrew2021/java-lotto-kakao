package lotto.domain;

import lotto.exception.IllegalTicketsStateException;

import java.util.Objects;

public class LottoTickets {
    private static final String ILLEGAL_TICKETS_MESSAGE = "가진 금액보다 더 많은 로또를 구매할 순 없습니다.";

    private LottoTicket autoTicket;
    private LottoTicket manualTicket;

    public LottoTickets(Money money, int manualTicket) {
        if (money.possibleNumberBuy() < manualTicket) {
            throw new IllegalTicketsStateException(ILLEGAL_TICKETS_MESSAGE);
        }
        this.autoTicket = new LottoTicket(money.possibleNumberBuy() - manualTicket);
        this.manualTicket = new LottoTicket(manualTicket);
    }

    public void useManualTicket() {
        this.manualTicket.useTicket();
    }

    public void useAutoTicket() {
        this.autoTicket.useTicket();
    }

    public boolean isManualTicketRemain() {
        return this.manualTicket.isRemain();
    }

    public boolean isAutoTicketRemain() {
        return this.autoTicket.isRemain();
    }

    public LottoTicket getAutoTicket() {
        return autoTicket;
    }

    public LottoTicket getManualTicket() {
        return manualTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(autoTicket, that.autoTicket) && Objects.equals(manualTicket, that.manualTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoTicket, manualTicket);
    }
}
