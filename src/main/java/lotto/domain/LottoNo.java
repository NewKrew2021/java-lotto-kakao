package lotto.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo>{

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNo(final Integer number) {
        if( !checkValidationLottoNo(number) ) {
            IllegalArgumentException error = new IllegalArgumentException();
            error.printStackTrace();
            throw error;
        }

        this.number = number;
    }

    public static boolean checkValidationLottoNo(final Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
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
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return "" + this.number;
    }
}
