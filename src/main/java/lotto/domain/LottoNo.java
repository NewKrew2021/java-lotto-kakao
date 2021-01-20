package lotto.domain;

import lotto.util.Validation;

import java.util.*;

public class LottoNo implements Comparable<LottoNo>{

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNo(final Integer number) {
        if( !Validation.validateLottoNo(number) ) {
            throw new IllegalArgumentException(Validation.INVALID_LOTTO_NUMBER);
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
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return "" + this.number;
    }
}
