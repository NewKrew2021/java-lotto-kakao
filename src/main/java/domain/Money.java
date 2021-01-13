package domain;

public class Money {
    private final long money;

    public Money(long money) {
        checkValid(money);
        this.money = money;
    }

    private void checkValid(long money) {
        if (money < Lotto.LOTTO_PRICE) {
            throw new InvalidMoneyException("금액이 부족합니다.");
        }
    }

    public void checkCanBuy(int count) {
        if (money < count * Lotto.LOTTO_PRICE) {
            throw new InvalidMoneyException("금액이 부족합니다.");
        }
    }

    public int getAutoLottoCount(int manualCount) {
        return (int) (this.money / Lotto.LOTTO_PRICE) - manualCount;
    }

    public long getMoney() {
        return money;
    }
}

