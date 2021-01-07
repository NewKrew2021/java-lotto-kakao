package lotto;

public class LottoGameNumber {

    public static final String LOTTO_MONEY_EXCEPTION_MESSAGE = "1000원 단위이며 양의 정수로 된 금액만 허용됩니다.";
    private static final int UNIT_OF_MONEY = 1000;

    private final int ticketNumber;

    public LottoGameNumber(int money) {
        if (money % UNIT_OF_MONEY != 0 || money <= 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_EXCEPTION_MESSAGE);
        }
        this.ticketNumber = money / UNIT_OF_MONEY;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
