package lotto.domain.dto;

public class TotalPrice {
    private final long price;

    public TotalPrice(long price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("Total price cannot be negative");
        }

        this.price = price;
    }

    public long getTotalPrice() {
        return price;
    }

    private boolean isNegative(long price) {
        return price < 0;
    }
}
