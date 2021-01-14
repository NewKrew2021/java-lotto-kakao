package lotto.domain;

import lotto.exception.BonusDuplicateException;
import lotto.utils.Splitter;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {

    private static final String DUPLICATE_BONUS_EXCEPTION_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String SPLIT_DELIMITER = ",";

    private final LottoNumbers winNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String string, int bonusNumber) {
        List<Integer> winNumbers = Splitter.splitToNumberBy(string, SPLIT_DELIMITER);
        validateWinAndBonusNumbers(winNumbers, bonusNumber);
        this.winNumbers = new LottoNumbers(winNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void validateWinAndBonusNumbers(List<Integer> winNumbers, int bonusNumber) {
        if (haveDuplicationBetween(winNumbers, bonusNumber)) {
            throw new BonusDuplicateException(DUPLICATE_BONUS_EXCEPTION_MESSAGE);
        }
    }

    private boolean haveDuplicationBetween(List<Integer> winNumbers, int bonusNumber) {
        return winNumbers.contains(bonusNumber);
    }

    public LottoNumbers getWinNumbers() {
        return this.winNumbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winNumbers, that.winNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers, bonusNumber);
    }
}
