package lotto.domain;

import lotto.exceptions.BadTicketException;
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
        validateNumbers(generatedNumbers);

        numbers = generatedNumbers;
    }

    public void validateNumbers(Set<Integer> numbers) {
        validateTicketSize(numbers.size());
        validateConsistingNumbers(numbers);
    }

    private void validateTicketSize(int size) {
        if(TICKET_SIZE != size) {
            throw new BadTicketException("ticket의 size가 잘못되었습니다.");
        }
    }

    private void validateConsistingNumbers(Set<Integer> numbers) {
        boolean existInvalidNumber = numbers.stream()
                .anyMatch(number -> (number < LOWER_LIMIT_OF_NUMBER || UPPER_LIMIT_OF_NUMBER < number));

        if(existInvalidNumber){
            throw new BadTicketException("유효하지 않은 범위의 숫자가 포함되어 있습니다.");
        }
    }

    /* 숫자 정보가 변경되는 것을 막기 위해 복사하여 전달한다. */
    public Set<Integer> getNumberData() {
        return new HashSet<>(numbers);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}