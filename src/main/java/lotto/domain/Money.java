package lotto.domain;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isInvalidMoneyValue(Money money){
        if(money.value < 0){
            return true;
        }
        return false;
    }

}
