package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    private final List<LottoNumber> numbers;

    public static LottoTicket ofLottoNumber(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket ofIntegerNumber(List<Integer> integerNumbers) {
        List<LottoNumber> numbers = Optional.ofNullable(integerNumbers)
                .orElseThrow(InvalidLottoNumberException::new)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoTicket(numbers);
    }

    private LottoTicket(List<LottoNumber> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> numbersSet = new HashSet<>(numbers);
        validateLength(numbersSet);
    }

    private void validateLength(Collection<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new InvalidLottoNumberException();
        }
    }

    public boolean isContains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int getMatchedCount(LottoTicket lottoWinningTicket) {
        int count = 0;
        for (LottoNumber number : numbers) {
            count += lottoWinningTicket.isContains(number) ? 1 : 0;
        }

        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
