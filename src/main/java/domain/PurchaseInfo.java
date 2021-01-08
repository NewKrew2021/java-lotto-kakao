package domain;

public class PurchaseInfo {
    private static final long LOTTO_PRICE = 1000L;
    private final long initialPrice;
    private long purchaseCount;

    public PurchaseInfo(long initialPrice) {
        this.initialPrice = initialPrice;
        this.purchaseCount = initialPrice / LOTTO_PRICE;
    }

    public long getPurchaseCount() {
        return purchaseCount;
    }

    public long getInitialPrice() {
        return initialPrice;
    }
}
