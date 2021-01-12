package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final String INVALID_RANGE_ERROR_MESSAGE = "%d ~ %d 사이의 숫자를 입력해주세요.";
    public static final int END_LOTTO_NUMBER = 45;
    public static final int START_LOTTO_NUMBER = 1;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER ; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String textNumber) {
        return of(Integer.parseInt(textNumber));
    }

    public static LottoNumber of(int lottoNumber) {
        LottoNumber resultLottoNumber = lottoNumbers.get(lottoNumber);
        if(resultLottoNumber == null) {
            throw new IllegalArgumentException(String
                    .format(INVALID_RANGE_ERROR_MESSAGE, START_LOTTO_NUMBER, END_LOTTO_NUMBER));
        }
        return resultLottoNumber;
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
