package lotto;

import java.util.Objects;

public class LotteryNumber {
    private final int number;

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

    public LotteryNumber(int number){
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("로또 번호는 1에서 45 사이의 수여야 합니다.");
        }
        this.number = number;
    }
}
