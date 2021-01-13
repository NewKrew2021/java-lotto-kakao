package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MAX_INT = 45;
    private static final int LOTTO_MIN_INT = 1;
    private final int number;

    public LottoNumber(int number) {

        if (number > LOTTO_MAX_INT || number < LOTTO_MIN_INT) {
            throw new IllegalArgumentException("1~45범위를 벗어난 숫자입니다.");
        }
        this.number = number;
    }


    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
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
    public String toString() {
        return String.valueOf(number);
    }

}
