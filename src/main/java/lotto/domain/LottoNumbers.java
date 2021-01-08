package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    public static final int NUMBER_COUNT = 6;
    private final Set<Integer> numbers;

    public LottoNumbers(Set<Integer> numbers) {
        isValid(numbers);
        this.numbers = numbers;
    }

    private void isValid(Set<Integer> numbers) {
        if(numbers.size() != NUMBER_COUNT)
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if(number < 1 || number > 45)
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자 중 하나여야 합니다.");
    }

    public int calculateRanking(WinnerNumbers winner) {
        int count = countIntersection(winner.getWinnerNumber());
        boolean matchBonus = numbers.contains(winner.getBonusBall());
        return Ranking(count, matchBonus);
    }

    private int Ranking(int count, boolean matchBonus) {
        if (count == 6)
            return 1;
        if (count == 5 && matchBonus)
            return 2;
        if (count == 5 && !matchBonus)
            return 3;
        if (count == 4)
            return 4;
        if (count == 3)
            return 5;
        return 6;
    }

    public int countIntersection(LottoNumbers winnerNumbers) {
        return (int) numbers.stream().filter(number -> winnerNumbers.contains(number)).count();
    }

    public boolean contains(int number){
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }


}
