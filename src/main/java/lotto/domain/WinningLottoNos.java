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
        return StatisticsType.of(matchCount, isBonusMatch);
    }

}
