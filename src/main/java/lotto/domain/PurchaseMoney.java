package lotto.domain;

import java.util.Objects;

public class PurchaseMoney {
    public static final int LOTTO_PRICE = 1000;
    private static final String MONEY_TYPE_EXCEPTION_MESSAGE = "구입금액은 정수를 입력해야 한다.";
    private static final String MONEY_RANGE_EXCEPTION_MESSAGE = "구입 금액은 양수여야 한다.";
    private static final String MONEY_REMAINDER_EXCEPTION_MESSAGE = "구입 금액은 %d의 배수여야 한다.";
    public static final String TOO_SMALL_MANUAL_QUANTITY_EXCEPTION_MESSAGE = "수동 구매 수량은 음수이면 안된다.";
    public static final String TOO_BIG_MANUAL_QUANTITY_EXCEPTION_MESSAGE = "수동 구매 수량은 전체 구매 수량을 초과할 수 없다.";
    private final int money;

    public PurchaseMoney(String moneyText) {
        int money;

        try {
            money = Integer.parseInt(moneyText);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MONEY_TYPE_EXCEPTION_MESSAGE);
        }

        checkRange(money);
        checkRemainder(money);
        this.money = money;
    }

    private void checkRange(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void checkRemainder(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(MONEY_REMAINDER_EXCEPTION_MESSAGE, LOTTO_PRICE));
        }
    }

    public void checkManualQuantity(int manualQuantity) {
        if (manualQuantity < 0) {
            throw new IllegalArgumentException(TOO_SMALL_MANUAL_QUANTITY_EXCEPTION_MESSAGE);
        }

        if (getLottoQuantity() < manualQuantity) {
            throw new IllegalArgumentException(TOO_BIG_MANUAL_QUANTITY_EXCEPTION_MESSAGE);
        }
    }

    public int getLottoQuantity() {
        return money / LOTTO_PRICE;
    }

    public double getProfitRatio(long prize) {
        return ((double) (prize - money) / money) * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseMoney that = (PurchaseMoney) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
