package domain;

import java.util.Objects;

public class LottoNumber {

    private static final String INVALID_RANGE_ERROR_MESSAGE = "%d ~ %d 사이의 숫자를 입력해주세요.";
    public static final int END_LOTTO_NUMBER = 45;
    public static final int START_LOTTO_NUMBER = 1;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < START_LOTTO_NUMBER || lottoNumber > END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String
                    .format(INVALID_RANGE_ERROR_MESSAGE, START_LOTTO_NUMBER, END_LOTTO_NUMBER));
        }
        this.lottoNumber = lottoNumber;
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
