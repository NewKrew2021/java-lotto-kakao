package domain;

public class PurchaseInfo {

    private final long needLottoPurchaseCount;
    private long currentBuyLottoCount;

    public PurchaseInfo(long needLottoPurchaseCount) {
        this.needLottoPurchaseCount = needLottoPurchaseCount;
    }

    public void buyLotto() {
        currentBuyLottoCount++;
    }

    public boolean canBuyLotto() { return currentBuyLottoCount < needLottoPurchaseCount; }

    public long getNeedLottoPurchaseCount() {
        return needLottoPurchaseCount;
    }

}
