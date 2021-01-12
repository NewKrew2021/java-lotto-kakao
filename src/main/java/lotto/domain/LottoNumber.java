package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new OutOfRangeException();
        }
        return lottoNumberCache.get(number);
    }

    public int getNumber() {
        return number;
    }

}
