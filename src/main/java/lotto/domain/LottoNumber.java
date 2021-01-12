package lotto.domain;

import lotto.exception.NumberRangeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    private static final String RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45까지의 숫자입니다.";
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int lottoNumber;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new NumberRangeException(RANGE_EXCEPTION_MESSAGE);
        }
        return lottoNumber;
    }

    public String getNumberToString() {
        return Integer.toString(this.lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
