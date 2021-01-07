package lotto.domain;

import java.util.Objects;

public class LotteryNumber {
    public static final int MIN_LOTTERYNUMBER = 1;
    public static final int MAX_LOTTERYNUMBER = 45;
    private static final String MSG_WRONG_LOTTERYNUMBER_RANGE = String.format(
            "로또 번호는 %d와 %d 사이의 수여야 합니다.", MIN_LOTTERYNUMBER, MAX_LOTTERYNUMBER);

    private final int number;

    public LotteryNumber(int number) {
        if (number < MIN_LOTTERYNUMBER || number > MAX_LOTTERYNUMBER) {
            throw new IllegalArgumentException(MSG_WRONG_LOTTERYNUMBER_RANGE);
        }
        this.number = number;
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


}
