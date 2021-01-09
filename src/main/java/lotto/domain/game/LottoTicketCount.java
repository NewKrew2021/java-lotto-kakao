package lotto.domain.game;

public class LottoTicketCount {

    public static final String LOTTO_MONEY_EXCEPTION_MESSAGE = "1000원 단위이며 양의 정수로 된 금액만 허용됩니다.";
    public static final int UNIT_OF_MONEY = 1000;

    private final int ticketCount;
    private int remainCount;

    public LottoTicketCount(int money) {
        if (money % UNIT_OF_MONEY != 0 || money <= 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_EXCEPTION_MESSAGE);
        }
        this.ticketCount = money / UNIT_OF_MONEY;
        this.remainCount = this.ticketCount;
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
