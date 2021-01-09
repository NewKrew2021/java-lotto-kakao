package lotto.domain.number;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

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
            throw new IllegalArgumentException("1~45 범위의 숫자만 허용됩니다");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    public int getNumber() {
        return number;
    }
}
