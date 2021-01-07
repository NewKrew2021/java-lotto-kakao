package lotto.domain;

import java.util.Objects;

public class Digit {
    private final int digit;

    public Digit(int digit) {
        if (isInvalidRange(digit)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이로만 입력해주세요.");
        }
        this.digit = digit;
    }

    private boolean isInvalidRange(int digit) {
        return digit < 1 || digit > 45;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit1 = (Digit) o;
        return digit == digit1.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }

    @Override
    public String toString() {
        return String.valueOf(digit);
    }
}
