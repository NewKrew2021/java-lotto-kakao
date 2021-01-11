package domain;

public class PurchaseInfo {

    public static final long LOTTE_PRICE = 1000L;

    private final long initialPrice;
    private final long needLottoPurchaseCount;
    private long currentBuyLottoCount;

    public PurchaseInfo(long initialPrice, long needLottoPurchaseCount) {
        if(initialPrice < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        this.initialPrice = initialPrice;
        this.needLottoPurchaseCount = needLottoPurchaseCount;
    }

    public void buyLotto() {
        currentBuyLottoCount++;
    }

    public boolean canBuyLotto() { return currentBuyLottoCount < needLottoPurchaseCount; }

    public long getInitialPrice() {
        return initialPrice;
    }

    public long getNeedLottoPurchaseCount() {
        return needLottoPurchaseCount;
    }

}
