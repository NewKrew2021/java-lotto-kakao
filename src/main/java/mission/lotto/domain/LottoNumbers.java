package mission.lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final Set<Number> numbers;
    private static final int MAX_NUMBERS_LENGTH = 6;

    public LottoNumbers(List<Integer> numbers) {
        Set<Number> lttoNums = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toSet());

        if (checkNumbersLength(lttoNums)) {
            throw new IllegalArgumentException("로또는 중복 없는 6자리만 가능합니다.");
        }

        this.numbers = lttoNums;
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
