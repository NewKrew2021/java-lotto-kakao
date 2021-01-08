package lotto.domain;

import lotto.StatisticsType;

import java.util.List;

public class WinningLottoNos {

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
        int matchCount = this.lottoTicket.getMatchCount(lottoTicket);
        boolean isBonusMatch = lottoTicket.isContains(bonusNo);
        return checkEnum(matchCount, isBonusMatch);
    }

    private StatisticsType checkEnum( int matchCount, boolean isBonusMatch) {
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
