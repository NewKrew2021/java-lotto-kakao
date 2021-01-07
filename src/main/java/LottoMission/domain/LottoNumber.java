package LottoMission.domain;

import java.util.Objects;

public class LottoNumber {

    private final int number;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 45;

    public LottoNumber(int number) {
        if(isInvalidNumber(number)){
            throw new IllegalArgumentException("숫자는 1~45 에 포함 되어야 합니다");
        }
        this.number = number;
    }

    private boolean isInvalidNumber(int number) {
        return number > MAX_NUMBER_VALUE || number < MIN_NUMBER_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
