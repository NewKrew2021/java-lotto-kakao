package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOWER_BOUND|| number > UPPER_BOUND) {
            throw new InvalidLottoNumberException("로또 번호는 "+LOWER_BOUND+"이상 "+UPPER_BOUND+"이하 이여야 합니다.");
        }
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

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.getNumber();
    }
}
