package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Ticket {
    public static final int LOWER_LIMIT_OF_NUMBER = 1;
    public static final int UPPER_LIMIT_OF_NUMBER = 45;
    public static final int TICKET_SIZE = 6;
    public static final int TICKET_PRICE = 1000;

    private final Set<Integer> numbers;

    public Ticket(GeneratingStrategy strategy) {
        numbers = strategy.generate();
    }

    /* 숫자 정보가 변경되는 것을 막기 위해 복사하여 전달한다. */
    public Set<Integer> getNumberData() {
        return new HashSet<>(numbers);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}