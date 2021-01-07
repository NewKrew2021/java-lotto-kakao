package lotto.domain;

import java.util.List;

public class WinnerNumbers {
    private final LottoNumbers winnerNo;
    int bonusBall;

    public WinnerNumbers(LottoNumbers numbers, int bonusBall){
        this.winnerNo = numbers;
        this.bonusBall = bonusBall;
    }

    public LottoNumbers getWinnerNumber() {
        return winnerNo;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
