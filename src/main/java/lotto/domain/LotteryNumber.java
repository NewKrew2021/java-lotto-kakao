package lotto.domain;

import lotto.exception.InvalidLotteryNumberException;

import java.util.Objects;

public class LotteryNumber {
    public static final int MIN_LOTTERYNUMBER = 1;
    public static final int MAX_LOTTERYNUMBER = 45;

    private final int number;

    public LotteryNumber(int number) {
        if (number < MIN_LOTTERYNUMBER || number > MAX_LOTTERYNUMBER) {
            throw new InvalidLotteryNumberException();
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
