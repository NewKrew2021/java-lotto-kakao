package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.List;
import java.util.Objects;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new InvalidLottoNumberException();
        }
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
