package domain;

public class PurchaseInfos {

    public static final long LOTTO_PRICE = 1000L;

    private PurchaseInfo selfLottoPurchaseInfo;
    private PurchaseInfo autoLottoPurchaseInfo;

    public PurchaseInfos(long initialMoney, long selfLottoCount) {
        selfLottoPurchaseInfo = new PurchaseInfo(initialMoney, selfLottoCount);
        long remainMoney = initialMoney - selfLottoCount * PurchaseInfo.LOTTE_PRICE;
        autoLottoPurchaseInfo = new PurchaseInfo(remainMoney, remainMoney / LOTTO_PRICE);
    }


    public boolean canBuyAutoLotto() {
        return autoLottoPurchaseInfo.canBuyLotto();
    }

    public boolean canBuySelfLotto() {
        return selfLottoPurchaseInfo.canBuyLotto();
    }
}
