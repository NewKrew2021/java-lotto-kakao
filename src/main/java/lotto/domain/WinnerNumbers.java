package lotto.domain;

import java.util.List;

public class WinnerNumbers {
    List<Integer> numbers;
    int bonusBall;

    public WinnerNumbers(List<Integer> numbers, int bonusBall){
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }
}
