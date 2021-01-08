package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (isInvalidRange(lottoNumber)) {
            throw new IllegalArgumentException("로또번호는 1~45 사이로만 입력해주세요.");
        }
        this.lottoNumber = lottoNumber;
    }

    private boolean isInvalidRange(int digit) {
        return digit < 1 || digit > 45;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return lottoNumber == lottoNumber1.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
