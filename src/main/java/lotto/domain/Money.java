package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class Money {
    public static final int LOTTERY_PRICE = 1000;
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public static int calculateLotteryCount(Money money) {
        if (isInvalidMoneyValue(money)) {
            throw new InvalidMoneyException();
        }
        return money.getValue() / LOTTERY_PRICE;
    }

    public static int calculateProfitRate(int count, long total) {
        int input = (count * LOTTERY_PRICE);
        return (int) ((double) (total - input) / input * 100);
    }

    public int getValue() {
        return value;
    }

    public static boolean isInvalidMoneyValue(Money money){
        return money.value < LOTTERY_PRICE;
    }

}
