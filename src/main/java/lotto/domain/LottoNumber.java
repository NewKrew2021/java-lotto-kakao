package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {  // LottoNumber를 반환하는 정적 팩토리 메서드
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        return lottoNumberCache.get(number);
    }

    public int getNumber() {
        return number;
    }

}
