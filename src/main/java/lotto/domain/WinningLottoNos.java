package lotto.domain;

import lotto.StatisticsType;

import java.util.List;

public class WinningLottoNos {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNo;

    public WinningLottoNos( List<Integer> numbers, int bonusNo ) {

        this.lottoNumbers = new LottoNumbers(numbers);
        this.bonusNo = new LottoNumber(bonusNo);

        if ( this.lottoNumbers.isContains(this.bonusNo) ) {
            throw new IllegalArgumentException();
        }

    }

    public StatisticsType getMatchResult(LottoNumbers lottoNumbers) {
        int matchCount = this.lottoNumbers.getMatchCount(lottoNumbers);
        boolean isBonusMatch = lottoNumbers.isContains(bonusNo);
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
