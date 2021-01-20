package lotto.domain;

import lotto.util.Validation;

import java.util.*;

public class LottoNo implements Comparable<LottoNo>{

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static Map<Integer, LottoNo> lottoNoCache = new HashMap<>();
    private final int number;

    private LottoNo(final Integer number) {
        if( !Validation.validateLottoNo(number) ) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
        }

        this.number = number;
    }

    static {
        for (int i = LottoNo.MIN_NUMBER; i <= LottoNo.MAX_NUMBER; i++) {
            lottoNoCache.put(i, new LottoNo(i));
        }
    }

    public static LottoNo of(int number) {
        return lottoNoCache.get(number);
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
