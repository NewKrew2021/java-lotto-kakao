package lotto.domain;

import lotto.domain.exceptions.BadTicketException;
import lotto.domain.strategies.GeneratingStrategy;

import java.util.HashSet;
import java.util.Set;

public class Ticket {
    public static final int LOWER_LIMIT_OF_NUMBER = 1;
    public static final int UPPER_LIMIT_OF_NUMBER = 45;
    public static final int TICKET_SIZE = 6;
    public static final int TICKET_PRICE = 1000;

    private final Set<Integer> numbers;

    public Ticket(GeneratingStrategy strategy) {
        Set<Integer> generatedNumbers = strategy.generate();
        if(!isValid(generatedNumbers)){
            throw new BadTicketException("잘못된 Ticket 객체 생성을 시도했습니다.");
        }

        numbers = generatedNumbers;
    }

    public boolean isValid(Set<Integer> numbers) {
        return isValidTicketSize(numbers.size()) && isConsistOfValidNumbers(numbers);
    }

    private boolean isValidTicketSize(int size) {
        return TICKET_SIZE == size;
    }

    private boolean isConsistOfValidNumbers(Set<Integer> numbers) {
        return numbers.stream().allMatch(
                number -> (LOWER_LIMIT_OF_NUMBER <= number && number <= UPPER_LIMIT_OF_NUMBER)
        );
    }

    /* 숫자 정보가 변경되는 것을 막기 위해 복사하여 전달한다. */
    public Set<Integer> getNumberData() {
        return new HashSet<>(numbers);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}