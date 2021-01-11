package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Number> numbers;

    public LottoTicket(Set<Number> numbers) {
        BallCountChecker.checkBallCount(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

}
