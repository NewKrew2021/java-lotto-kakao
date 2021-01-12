package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("천원 이상의 금액을 입력해 주세요");
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public NumOfLotto howMany() {
        return new NumOfLotto(money / LOTTO_PRICE);
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
