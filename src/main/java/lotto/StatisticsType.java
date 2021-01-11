package lotto;

public enum StatisticsType {
    NONE,
    THREE,
    FOUR,
    FIVE,
    FIVE_WITH_BONUS,
    SIX;

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
