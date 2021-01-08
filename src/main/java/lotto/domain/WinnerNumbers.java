package lotto.domain;

import java.util.List;
import java.util.Set;

public class WinnerNumbers {
    private final LottoNumbers winnerNumbers;
    int bonusBall;

    public WinnerNumbers(Set<Integer> numbers, int bonusBall){
        this.winnerNumbers = new LottoNumbers(numbers);
        this.bonusBall = bonusBall;
    }

    public LottoNumbers getWinnerNumber() {
        return winnerNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
