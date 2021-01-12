package lotto.domain;

import lotto.StatisticsType;

import java.util.List;
import java.util.Objects;

public class WinningLottoNos {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNos( List<Integer> numbers, int bonusNumber) {
        this(new LottoNumbers(numbers), new LottoNumber(bonusNumber));
    }
    public WinningLottoNos(LottoNumbers lottoNumbers, LottoNumber lottoNumber){
        if ( this.lottoNumbers.isContains(lottoNumber) ) {
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = lottoNumber;
    }

    public StatisticsType getMatchResult(LottoNumbers lottoNumbers) {
        int matchCount = this.lottoNumbers.getMatchCount(lottoNumbers);
        boolean isBonusMatch = lottoNumbers.isContains(bonusNumber);
        return StatisticsType.of(matchCount, isBonusMatch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoNos that = (WinningLottoNos) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }
}
