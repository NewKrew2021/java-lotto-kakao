package domain;

public class PurchaseInfo {

    public static long LOTTE_PRICE = 1000L;

    private final long initialPrice;
    private final long selfLottoPurchaseCount;
    private long currentBuyLottoCount;

    public PurchaseInfo(long initialPrice, long selfLottoPurchaseCount) {
        if((initialPrice - selfLottoPurchaseCount * LOTTE_PRICE) < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        this.initialPrice = initialPrice;
        this.selfLottoPurchaseCount = selfLottoPurchaseCount;
    }

    public void buyLotto() {
        currentBuyLottoCount++;
    }

    public boolean buyAllSelfLottos() {
        return currentBuyLottoCount >= selfLottoPurchaseCount;
    }

    public boolean buyAllAutoLottos() {
        return currentBuyLottoCount >= (initialPrice / LOTTE_PRICE);
    }

    public long getSelfLottoPurchaseCount() {
        return selfLottoPurchaseCount;
    }

}
