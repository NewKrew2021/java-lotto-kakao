package lotto.domain;

import lotto.util.MatchResult;

public class MatchNumber {
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;

    private final WinningNumber winningNumber;
    private final LottoNumber bonusNumber;

    private MatchNumber(WinningNumber winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = LottoNumber.of(bonusNumber);
        if (!isValid()) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 동일할 수 없습니다;");
        }
    }

    public static MatchNumber of(String numbersText, int bonusNumber) {
        return new MatchNumber(WinningNumber.fromNumbersText(numbersText), bonusNumber);
    }

    private boolean isValid() {
        return !winningNumber.isContain(bonusNumber);
    }

    public MatchResult getMatchResult(LottoNumber lottoNumber) {
        if (winningNumber.isContain(lottoNumber)) {
            return MatchResult.WIN;
        }
        if (lottoNumber == bonusNumber) {
            return MatchResult.BONUS;
        }
        return MatchResult.NOTHING;
    }
}
