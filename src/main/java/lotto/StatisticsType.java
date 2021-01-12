package lotto;

public enum StatisticsType {
    NONE(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_WITH_BONUS(30000000),
    SIX(2000000000);

    public final int price;

    StatisticsType(int price){
        this.price = price;
    }
    public static StatisticsType of( int matchCount, boolean isBonusMatch) {
        if( matchCount == 3 )
            return StatisticsType.THREE;
        if( matchCount == 4 )
            return StatisticsType.FOUR;
        if( matchCount == 5 )
            return isBonusMatch ? StatisticsType.FIVE_WITH_BONUS : StatisticsType.FIVE;
        if( matchCount == 6 )
            return StatisticsType.SIX;
        return StatisticsType.NONE;
    }
}
