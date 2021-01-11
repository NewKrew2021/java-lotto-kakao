package lotto.domain;

import lotto.domain.vo.LottoNumber;

public class WinningNumbers {
    private final LottoNumbers luckyNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        if (isDuplicate(luckyNumbers, bonusNumber)) {
            throw new IllegalArgumentException("Bonus number already exists in lucky numbers");
        }

        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
    }

    public MatchResult getMatchResult(LottoNumbers lottoTicket) {
        return MatchResult.valueOf(lottoTicket.getMatchCount(luckyNumbers), lottoTicket.isMatchBonus(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return this.luckyNumbers.equals(that.luckyNumbers)
                && this.bonusNumber.equals(that.bonusNumber);
    }

    private boolean isDuplicate(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        return luckyNumbers.contains(bonusNumber);
    }
}
