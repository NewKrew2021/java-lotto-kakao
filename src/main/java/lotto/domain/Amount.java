package lotto.domain;

import java.math.BigDecimal;

public class Amount {
    private final int LOTTO_PRICE = 1000;
    private final int amont;
    private final int chageMoney;
    private final int money;

    public Amount(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또를 구매할 수 없는 금액입니다.");
        }
        this.money = money;
        this.amont=money/LOTTO_PRICE;
        this.chageMoney=money-amont*LOTTO_PRICE;
    }

    public BigDecimal profitRatio(int totalPrize) {
        return new BigDecimal(totalPrize / (double) money).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public int BuyCount() {
        return amont;
    }
}
