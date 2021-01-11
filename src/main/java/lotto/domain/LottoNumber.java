package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {

        if (number > 45 || number < 0) {
            throw new IllegalArgumentException("1~45범위를 벗어난 숫자입니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
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
