package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinAndBonusNumbers {

    private final LottoNumbers winNumbers;
    private final BonusNumber bonusNumber;

    public WinAndBonusNumbers(List<Integer> winNumbers, int bonusNumber) {
        validateWinAndBonusNumbers(winNumbers, bonusNumber);
        this.winNumbers = new LottoNumbers(winNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateWinAndBonusNumbers(List<Integer> winNumbers, int bonusNumber) {
        if (hasDuplicationBetween(winNumbers, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicationBetween(List<Integer> winNumbers, int bonusNumber) {
        return winNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinAndBonusNumbers that = (WinAndBonusNumbers) o;
        return Objects.equals(winNumbers, that.winNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers, bonusNumber);
    }
}
