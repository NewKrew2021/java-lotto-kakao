package lotto.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    int number;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoNo(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1~45 사이어야 합니다");
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNo o) {
        if (this.number < o.number)
            return 1;
        if (this.number > o.number)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "" + this.number;
    }
}
