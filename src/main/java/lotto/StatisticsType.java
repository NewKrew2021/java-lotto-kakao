package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StatisticsType {
    NONE(0, 0, false),
    THREE(5000, 3, false),
    FOUR(50000, 4, false),
    FIVE(1500000, 5, false),
    FIVE_WITH_BONUS(30000000, 5, true),
    SIX(2000000000, 6, false);

    public final int price;
    public final int howmany;
    public final boolean isBonus;

    private StatisticsType(int price, int howmany, boolean isBonus){
        this.price = price;
        this.howmany = howmany;
        this.isBonus = isBonus;
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

    public static List<StatisticsType> valuesExceptNone(){
        return Arrays.stream(StatisticsType.values())
                .filter((StatisticsType type)-> type != StatisticsType.NONE)
                .collect(Collectors.toList());
    }
}
