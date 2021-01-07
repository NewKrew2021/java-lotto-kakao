package lotto.domain;

import java.util.List;

public class WinnerNumbers {
    private final List<Integer> winnerNo;
    int bonusBall;

    public WinnerNumbers(List<Integer> numbers, int bonusBall){
        this.winnerNo = numbers;
        this.bonusBall = bonusBall;
    }
}
