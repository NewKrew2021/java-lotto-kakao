package lotto.domain;

import java.math.BigDecimal;

public class Amount {
    private final int LOTTO_PRICE = 1000;
    private int autoAmount;
    private int manualAmount;
    private final double changes;
    private final double totalPrice;

    public Amount(int money, int manualAmount) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또를 구매할 수 없는 금액입니다.");
        }
        this.autoAmount = money / LOTTO_PRICE;
        this.totalPrice = autoAmount * LOTTO_PRICE;
        this.changes = money - totalPrice;
        buyManualLotto(manualAmount);
    }

    public void buyManualLotto(int manualAmount) {
        if (manualAmount > autoAmount) {
            throw new IllegalArgumentException("구매 가능한 수량을 초과했습니다");
        }
        this.manualAmount = manualAmount;
        this.autoAmount = this.autoAmount - manualAmount;
    }

    public BigDecimal profitRatio(int totalPrize) {
        return new BigDecimal(totalPrize / totalPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public int autoCount() {
        return autoAmount;
    }

    public int manualCount() {
        return manualAmount;
    }
}
