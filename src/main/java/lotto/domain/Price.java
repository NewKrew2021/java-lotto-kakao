package lotto.domain;

import java.util.Objects;

public class Price {
    private static final int DIV_NO = 1000;
    private final long price;

    public Price(int price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
        }
        this.price = price;
    }

    private boolean isNegative(int price) {
        return price < 0;
    }

    public int count() {
        return (int) (price / DIV_NO);
    }

    public long getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
