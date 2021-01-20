package lotto.domain;

import java.util.Arrays;
import java.util.List;


public enum StatisticsType {
    NONE( 0, 0, false ),
    THREE( 3, 5_000, false ),
    FOUR( 4, 50_000, false ),
    FIVE ( 5, 1_500_000, false ),
    FIVE_WITH_BONUS ( 5, 30_000_000, true ),
    SIX (6, 2_000_000_000, false );

    private int matchCount;
    private int jackpot;
    private boolean bonusBallMatch;
    private static List<StatisticsType> typeCache = Arrays.asList(StatisticsType.values());

    StatisticsType(int matchCount, int jackpot, boolean bonusBallMatch) {
        this.matchCount = matchCount;
        this.jackpot = jackpot;
        this.bonusBallMatch = bonusBallMatch;
    }

    public int getJackpot() {
        return this.jackpot;
    }

    public static StatisticsType matchTickets(int matchCount, boolean isBonusMatch) {
        return StatisticsType.typeCache.stream()
                .filter(match -> match.isMatch(matchCount, isBonusMatch))
                .findAny()
                .orElse(NONE);
    }

    private boolean isMatch(int matchCount, boolean isBonusMatch) {
        if( matchCount == FIVE.matchCount ) {
            return this.matchCount == matchCount && this.bonusBallMatch == isBonusMatch;
        }
        return this.matchCount == matchCount;
    }
}
