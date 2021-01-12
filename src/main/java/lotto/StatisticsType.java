package lotto;

public enum StatisticsType {
    NONE( 0, 0 ),
    THREE( 3, 5000 ),
    FOUR( 4, 50000 ),
    FIVE ( 5, 1500000 ),
    FIVE_WITH_BONUS ( 5, 30000000 ),
    SIX (6, 2000000000 );

    private int matchCount;
    private int jackpot;

    StatisticsType(int matchCount, int jackpot) {
        this.matchCount = matchCount;
        this.jackpot = jackpot;
    }

    public int getJackpot() {
        return this.jackpot;
    }

    public static StatisticsType matchTickts(int matchCount, boolean isBonusMatch) {
        if( matchCount > FOUR.matchCount ) {
            return matchNumbersUpper4(matchCount, isBonusMatch);
        }
        return matchNumbersUnder4(matchCount);
    }

    private static StatisticsType matchNumbersUpper4(int matchCount, boolean isBonusMatch) {
        if( isBonusMatch ) {
            return FIVE_WITH_BONUS;
        }
        if( SIX.matchCount == matchCount ) {
            return SIX;
        }
        return FIVE;
    }

    private static StatisticsType matchNumbersUnder4(int matchCount) {
        if( FOUR.matchCount == matchCount ) {
            return FOUR;
        }
        if( THREE.matchCount == matchCount ) {
            return THREE;
        }
        return NONE;
    }

}
