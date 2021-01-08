package lotto.domain;

import lotto.StatisticsType;

import java.util.HashMap;
import java.util.List;

public class WinningLottoNos {

    private static final HashMap<Integer, StatisticsType> MATCH_TABLE = new HashMap<Integer, StatisticsType>() {{
        put(0, StatisticsType.NONE );
        put(1, StatisticsType.NONE );
        put(2, StatisticsType.NONE );
        put(3, StatisticsType.THREE );
        put(4, StatisticsType.FOUR );
        put(5, StatisticsType.FIVE );
        put(6, StatisticsType.SIX );
    }};

    private LottoTicket lottoTicket;
    private LottoNo bonusNo;

    public WinningLottoNos( List<Integer> numbers, int bonusNo ) {

        this.lottoTicket = new LottoTicket(numbers);
        this.bonusNo = new LottoNo(bonusNo);

        if ( this.lottoTicket.isContains(this.bonusNo) ) {
            throw new IllegalArgumentException();
        }

    }

    public StatisticsType isWinning(LottoTicket lottoTicket) {
        int matchCount = this.lottoTicket.matchTickets(lottoTicket);
        boolean isBonusMatch = lottoTicket.isContains(bonusNo);
        return checkType(matchCount, isBonusMatch);
    }

    private StatisticsType checkType(int matchCount, boolean isBonusMatch) {
        StatisticsType matchResult = MATCH_TABLE.get(matchCount);
        if( matchResult == StatisticsType.FIVE && isBonusMatch ) {
            return StatisticsType.FIVE_WITH_BONUS;
        }
        return matchResult;
    }

}
