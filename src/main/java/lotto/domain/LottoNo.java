package lotto.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo>{

    int number;

    public LottoNo(Integer number) {
        if( !checkValidationLottoNo(number) ) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public static boolean checkValidationLottoNo(Integer number) {
        return number >= 1 && number <= 45;
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
        return Integer.compare(o.number, this.number);
    }

    @Override
    public String toString() {
        return "" + this.number;
    }
}
