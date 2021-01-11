package lotto.domain;

import lotto.exception.TooLowMoneyException;

import java.util.Objects;

public class Money {
    private static final int MIN_MONEY = 10;
    private int money;

    public Money(int money) {
        if (money < MIN_MONEY) {
            throw new TooLowMoneyException(MIN_MONEY);
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int howMany(int productPrice) {
        return money / productPrice;
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
