package domain;

public class PurchaseInfos {

    public static final long LOTTO_PRICE = 1000L;

    private PurchaseInfo selfLottoPurchaseInfo;
    private PurchaseInfo autoLottoPurchaseInfo;

    public PurchaseInfos(long initialMoney, long selfLottoCount) {
        long remainMoney = initialMoney - selfLottoCount * LOTTO_PRICE;
        if (remainMoney < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        selfLottoPurchaseInfo = new PurchaseInfo(selfLottoCount);
        autoLottoPurchaseInfo = new PurchaseInfo(remainMoney / LOTTO_PRICE);
    }

    public long getNeededSelfLottoCount() {
        return selfLottoPurchaseInfo.getNeedLottoPurchaseCount();
    }

    public long getNeededAutoLottoCount() {
        return autoLottoPurchaseInfo.getNeedLottoPurchaseCount();
    }

    public void buySelfLotto() {
        selfLottoPurchaseInfo.buyLotto();
    }

    public void buyAutoLotto() {
        autoLottoPurchaseInfo.buyLotto();
    }

    public boolean canBuyAutoLotto() {
        return autoLottoPurchaseInfo.canBuyLotto();
    }

    public boolean canBuySelfLotto() {
        return selfLottoPurchaseInfo.canBuyLotto();
    }
}
