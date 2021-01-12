package lotto.domain.number;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    protected static final int MIN_LOTTO_NUMBER = 1;
    protected static final int MAX_LOTTO_NUMBER = 45;
    public static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "1~45 범위의 숫자만 허용됩니다";

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    private static class LottoNumberCache {
        static final List<LottoNumber> cache = new ArrayList<>();

        static {
            for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
                cache.add(new LottoNumber(i));
            }
        }
    }

    public static LottoNumber valueOf(int number) {
        try {
            return LottoNumberCache.cache.get(number - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    protected int getNumber() {
        return number;
    }

}
