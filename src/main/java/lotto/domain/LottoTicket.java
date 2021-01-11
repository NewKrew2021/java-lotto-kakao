package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int BALL_COUNT = 6;
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
