package lotto.domain;

import lotto.domain.LottoNo;
import lotto.domain.LottoNos;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNos {

    private LottoNos lottoNos;
    private LottoNo bonusNo;

    public WinningLottoNos( List<Integer> numbers, int bonusNo ) {

        this.lottoNos = new LottoNos(numbers);
        this.bonusNo = new LottoNo(bonusNo);

        if ( this.lottoNos.isContains(this.bonusNo) ) {
            throw new IllegalArgumentException();
        }

    }

    public List<Integer> isWinning(LottoNos lottoNos) {
        List<Integer> matchResult = new ArrayList<>();
        matchResult.add(this.lottoNos.getMatchCount(lottoNos));
        matchResult.add(lottoNos.isContains(bonusNo) ? 1 : 0);
        return matchResult;
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
