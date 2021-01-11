package lotto.domain.game;

public class LottoTicketCount {

    public static final int MONEY_PER_LOTTO = 1000;

    private final int ticketCount;
    private int remainCount;

    LottoTicketCount(int ticketCount) {
        if (ticketCount <= 0) {
            throw new IllegalArgumentException("티켓의 갯수는 양의 정수여야 합니다.");
        }

        this.ticketCount = ticketCount;
        this.remainCount = ticketCount;
    }

    public static LottoTicketCount fromMoney(int money) {
        if (money % MONEY_PER_LOTTO != 0) {
            throw new IllegalArgumentException("1000원 단위의 금액만 허용됩니다.");
        }

        return new LottoTicketCount(money / MONEY_PER_LOTTO);
    }

    public boolean isTicketRemain() {
        return remainCount > 0;
    }

    public void useTicket() {
        remainCount--;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
