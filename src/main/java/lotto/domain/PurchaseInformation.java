package lotto.domain;

import java.math.BigDecimal;

public class PurchaseInformation {
    public static final int TICKET_PRICE = 1_000;

    private static final String TICKET_COUNT_ERROR = "구입 금액 또는 수동 로또 수를 잘못 입력했습니다.";
    private static final String TICKET_PRICE_ERROR = "구입 금액은 " + TICKET_PRICE + "원 이상 입력해주세요.";

    private final int price;
    private final int manualCount;
    private final int autoCount;

    public PurchaseInformation(int price, int manualCount) {
        this.price = price;
        this.manualCount = manualCount;
        this.autoCount = price / TICKET_PRICE - manualCount;
        checkPricePositive();
        checkTicketCount();
    }

    private void checkTicketCount() {
        if(autoCount < 0) {
            throw new IllegalArgumentException(TICKET_COUNT_ERROR);
        }
    }

    private void checkPricePositive() {
        if(this.price < TICKET_PRICE) {
            throw new IllegalArgumentException(TICKET_PRICE_ERROR);
        }
    }

    public int getPurchasedPrice() {
        return (manualCount + autoCount) * TICKET_PRICE;
    }

    public int getPrice() {
        return this.price;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
