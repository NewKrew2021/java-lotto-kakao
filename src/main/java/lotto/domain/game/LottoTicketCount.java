package lotto.domain.game;

public class LottoTicketCount {

    private static final int MIN_TICKET_COUNT = 1;
    private static final int MONEY_PER_LOTTO = 1000;

    private final int ticketCount;
    private int remainCount;

    public LottoTicketCount(int ticketCount) {
        if (ticketCount < MIN_TICKET_COUNT) {
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

    public int calculatePrice() {
        return ticketCount * MONEY_PER_LOTTO;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
