package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    private final TreeSet<LottoNumber> numbers;

    private Lotto(TreeSet<LottoNumber> numbers) {
        validateLength(numbers);

        this.numbers = numbers;
    }

    public static Lotto of(TreeSet<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto from(NumberGenerateStrategy strategy){
        return strategy.generate();
    }

    private void validateLength(Collection<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new InvalidLottoNumberException("로또 번호가 중복이거나 개수가 올바르지 않습니다.");
        }
    }

    public boolean isContains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int getMatchedCount(Lotto target) {
        int count = 0;
        for (LottoNumber number : numbers) {
            count += target.isContains(number) ? 1 : 0;
        }

        return count;
    }

    public List<Integer> getLottoTicketInfo() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
