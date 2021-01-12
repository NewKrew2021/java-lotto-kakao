package lotto.domain.game;

public class LottoGameCount {

    public static final String LOTTO_MONEY_EXCEPTION_MESSAGE = "1000원 단위이며 양의 정수로 된 금액만 허용됩니다.";
    public static final String LOTTO_MANUAL_EXCEPTION_MESSAGE = "0 이상이며, 투입 금액에 따른 총 티켓 개수 이하의 수동 티켓 개수만 허용됩니다.";
    private static final int UNIT_OF_MONEY = 1000;

    private final int ticketCount;
    private int remainCount;
    private int manualTicketCount;

    public LottoGameCount(int money) {
        validMoney(money);
        this.ticketCount = money / UNIT_OF_MONEY;
        this.remainCount = this.ticketCount;
    }

    public LottoGameCount(int money, int manualTicketCount) {
        validMoney(money);
        this.ticketCount = money / UNIT_OF_MONEY;
        this.remainCount = this.ticketCount;
        validManualTicketCount(manualTicketCount);
        this.manualTicketCount = manualTicketCount;
    }

    private void validMoney(int money) {
        if (money % UNIT_OF_MONEY != 0 || money <= 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_EXCEPTION_MESSAGE);
        }
    }

    private void validManualTicketCount(int manualTicketCount) {
        if (manualTicketCount < 0 || manualTicketCount > ticketCount) {
            throw new IllegalArgumentException(LOTTO_MANUAL_EXCEPTION_MESSAGE);
        }
    }

    protected int calculateTotalTicketMoney() {
        return ticketCount * UNIT_OF_MONEY;
    }

    public boolean isTicketRemain() {
        return !(remainCount == 0);
    }

    public boolean isManualTicketRemain() {
        return (remainCount + manualTicketCount) > ticketCount;
    }

    public void useTicket() {
        remainCount--;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getAutoTicketCount() {
        return ticketCount - manualTicketCount;
    }

}
