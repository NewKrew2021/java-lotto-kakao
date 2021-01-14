package lotto.domain;

import lotto.exception.NumberRangeException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    static final int MAX_LOTTO_NUMBER = 45;
    static final int MIN_LOTTO_NUMBER = 1;
    private static final String RANGE_EXCEPTION_MESSAGE = "로또 번호는 "+MIN_LOTTO_NUMBER+"부터 "
                                                          +MAX_LOTTO_NUMBER+"까지의 숫자입니다.";
    private static final List<LottoNumber> lottoNumberCache = IntStream
        .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new NumberRangeException(RANGE_EXCEPTION_MESSAGE);
        }
        return lottoNumberCache.get(number - 1);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
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
}
