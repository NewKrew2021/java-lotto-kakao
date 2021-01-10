package lotto.domain.dto;

public class InsertPrice {
    private final int price;

    public InsertPrice(int price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("price cannot be negative.");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private boolean isNegative(int price) {
        return price < 0;
    }
}
