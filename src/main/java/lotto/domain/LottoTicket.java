package lotto.domain;

import lotto.exception.IllegalTicketStateException;

import java.util.Objects;

public class LottoTicket {
    private static final String ILLEGAL_TICKET_STATE_MESSAGE = "티켓의 수는 0보다 작을 수 없습니다.";
    private int ticket;

    public LottoTicket(int ticket) {
        if (ticket < 0) {
            throw new IllegalTicketStateException(ILLEGAL_TICKET_STATE_MESSAGE);
        }
        this.ticket = ticket;
    }

    public boolean isRemain() {
        return this.ticket > 0;
    }

    public void useTicket() {
        this.ticket--;
    }

    public int getTicket() {
        return this.ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return ticket == that.ticket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
