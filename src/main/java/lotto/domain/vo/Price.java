package lotto.domain.vo;

public class Price {
    private final long price;

    public Price(long price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("Total price cannot be negative");
        }

        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    private boolean isNegative(long price) {
        return price < 0;
    }
}
