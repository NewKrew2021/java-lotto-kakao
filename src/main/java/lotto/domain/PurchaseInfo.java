package lotto.domain;

import java.util.Objects;

public class PurchaseInfo {

    private final PurchaseMoney purchaseMoney;
    private final int manualLottoAmount;

    public PurchaseInfo(PurchaseMoney purchaseMoney, int manualLottoAmount) {
        checkManualAmount(purchaseMoney, manualLottoAmount);
        this.purchaseMoney = purchaseMoney;
        this.manualLottoAmount = manualLottoAmount;
    }

    private void checkManualAmount(PurchaseMoney purchaseMoney, int manualLottoAmount) {
        if (manualLottoAmount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 0개 이상이어야 합니다.");
        }
        if (purchaseMoney.getLottoAmount() < manualLottoAmount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 구입가능한 로또 수보다 많으면 안됩니다.");
        }
    }

    public int getManualLottoAmount() {
        return manualLottoAmount;
    }

    public int getAutoLottoAmount() {
        return purchaseMoney.getLottoAmount() - manualLottoAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseInfo that = (PurchaseInfo) o;
        return manualLottoAmount == that.manualLottoAmount && Objects.equals(purchaseMoney, that.purchaseMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseMoney, manualLottoAmount);
    }
}
