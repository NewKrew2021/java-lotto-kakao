package lotto.setting;

public class Prize {

    private Prize(){
        throw new IllegalStateException("Prize class is not allowed to construct.");
    }

    public static final long MONEY_FOR_FIRST = 2_000_000_000;
    public static final long MONEY_FOR_SECOND = 30_000_000;
    public static final long MONEY_FOR_THIRD = 1_500_000;
    public static final long MONEY_FOR_FOURTH = 50_000;
    public static final long MONEY_FOR_FIFTH = 5_000;
    public static final long MONEY_FOR_OUT = 0;
}
