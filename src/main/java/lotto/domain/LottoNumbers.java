package lotto.domain;

import java.util.Set;

public class LottoNumbers {
    public static final int NUMBER_COUNT = 6;
    Set<Integer> numbers;

    public LottoNumbers(Set<Integer> numbers) {
        isValid(numbers);
        this.numbers = numbers;
    }

    private void isValid(Set<Integer> numbers) {
        if(numbers.size() != NUMBER_COUNT)
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
        for (Integer number : numbers) {
            checkNumberRange(number);
        }
    }

    private void checkNumberRange(Integer number) {
        if(number < 1 || number > 45)
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자 중 하나여야 합니다.");
    }
}
