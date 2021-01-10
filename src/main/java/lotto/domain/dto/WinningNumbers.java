package lotto.domain.dto;

import lotto.domain.LottoNumbers;

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

    public LottoNumbers getLuckyNumbers() {
        return luckyNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
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
