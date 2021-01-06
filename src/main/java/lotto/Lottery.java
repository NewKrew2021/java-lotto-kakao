package lotto;

import java.util.List;
import java.util.Objects;

public class Lottery {
    private final List<LotteryNumber> numbers;
    //1~45
    public Lottery(List<LotteryNumber> numbers){
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
