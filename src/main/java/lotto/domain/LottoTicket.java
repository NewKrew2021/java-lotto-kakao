package lotto.domain;

import lotto.domain.strategy.TicketStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int BALL_COUNT = 6;

    private static final String DELIMITER = ",";
    private static final String BLANK = " ";

    private final String NUMBER_COUNT_ERROR = "로또 번호는 " + BALL_COUNT + "개만 입력해 주세요.";

    private final Set<Number> numbers;

    public LottoTicket(Set<Number> numbers) {
        checkBallCount(numbers);
        this.numbers = numbers;
    }

    public static LottoTicket from(String rawNumbers) {
        return new LottoTicket(Arrays.stream(rawNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Number::of)
                .collect(Collectors.toCollection(TreeSet::new)));
    }

    public static LottoTicket from(TicketStrategy strategy) {
        return new LottoTicket(strategy.makeNumbers());
    }

    public int matchCount(LottoTicket comparedTicket) {
        return (int) numbers.stream().filter(comparedTicket::contains).count();
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    private void checkBallCount(Set<Number> numbers) {
        if(numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

}
