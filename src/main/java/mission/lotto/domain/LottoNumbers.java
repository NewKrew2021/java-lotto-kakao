package mission.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {

    private final Set<Number> numbers;
    private static final int MAX_NUMBERS_LENGTH = 6;

    public LottoNumbers(List<Integer> numbers) {
        Set<Number> temp = new HashSet<>();
        for (int number : numbers) {
            temp.add(new Number(number));
        }

        if (checkNumbersLength(temp)) {
            throw new IllegalArgumentException("로또는 중복 없는 6자리만 가능합니다.");
        }
        this.numbers = temp;
    }

    private boolean checkNumbersLength(Set<Number> temp) {
        return temp.size() != MAX_NUMBERS_LENGTH;
    }

    public boolean isContainLottoNumber(Number lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public Set<Number> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
