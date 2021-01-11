package lotto.domain;

import java.util.Set;

public class WinnerNumbers {
    private final LottoNumbers winnerNumbers;
    int bonusBall;

    public WinnerNumbers(Set<Integer> numbers, int bonusBall) {
        isValid(numbers, bonusBall);
        this.winnerNumbers = new LottoNumbers(numbers);
        this.bonusBall = bonusBall;
    }

    private void isValid(Set<Integer> numbers, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 담청번호에 포함되지 않는 숫자여야 합니다.");
        }
    }

    public LottoNumbers getWinnerNumber() {
        return winnerNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
