package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new InvalidLottoNumberException();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.getNumber();
    }
}
