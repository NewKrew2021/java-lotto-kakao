package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (!isValidRange(lottoNumber)){
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자입니다.");
        }
    }

    private boolean isValidRange(int lottoNumber) {
        return lottoNumber <= MAX_LOTTO_NUMBER && lottoNumber >= MIN_LOTTO_NUMBER;
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
