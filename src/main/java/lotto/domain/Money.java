package lotto.domain;

import java.util.Objects;

public class Money {

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int possibleNumberBuy() {
        return this.money / 1000;
    }

    public double getProfitRate(int profitMoney) {
        return (double)profitMoney / (double)money;
    }

    private void validateMoney(int money) {
        if (!isOverThousand(money)) {
            throw new IllegalArgumentException("1000원 이상의 금액이 필요합니다.");
        }
    }

    private boolean isOverThousand(int money) {
        return money >= 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
