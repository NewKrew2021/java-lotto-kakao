package lotto.domain;

import java.util.Objects;

public class PurchaseMoney {
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public PurchaseMoney(int money) {
        checkRange(money);
        checkMultiple(money);
        this.money = money;
    }

    public int getLottoAmount() {
        return money / LOTTO_PRICE;
    }

    private void checkRange(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("구입 금액은 양수여야 한다.");
        }
    }

    private void checkMultiple(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000의 배수여야 한다.");
        }
    }

    public double getProfitRatio(long prize) {
        return ((double) prize / money) * 100;
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
