package lotto;

public class PurchaseMoney {
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public PurchaseMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("구입 금액은 양수여야 한다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000의 배수여야 한다.");
        }

        this.money = money;
    }

    public int getLottoAmount() {
        return money / LOTTO_PRICE;
    }
}
