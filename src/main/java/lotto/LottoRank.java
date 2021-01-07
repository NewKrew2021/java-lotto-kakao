package lotto;

public enum LottoRank {
    FIFTH(5000, "3개 일치"),
    FOURTH(50000, "4개 일치"),
    THIRD(1500000, "5개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(2000000000, "6개 일치");

    private final long price;
    private final String message;

    LottoRank(long price, String message) {
        this.price = price;
        this.message = message;
    }

    @Override
    public String toString() {
        return message + " (" + price + "원)";
    }

    public long getPrice() {
        return price;
    }
}
