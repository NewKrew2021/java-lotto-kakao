package lotto.domain;

import lotto.setting.Format;
import lotto.setting.Rank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ticket {
    public static final int LOWER_LIMIT_OF_NUMBER = 1;
    public static final int UPPER_LIMIT_OF_NUMBER = 45;
    private static final int TICKET_SIZE = 6;

    private final Set<Integer> numbers;

    public Ticket(Set<Integer> numbers) {
        if(!isValid(numbers)){
            throw new IllegalArgumentException("유효하지 않은 ticket 값입니다.");
        }
        this.numbers = numbers;
    }

    public boolean isValid(Set<Integer> numbers){
        return isValidSize(numbers.size()) && isValidValues(numbers);
    }

    public boolean isValidSize(int testTicketSize) {
        return TICKET_SIZE == testTicketSize;
    }

    public static boolean isValidValues(Set<Integer> numbers) {
        return numbers.stream().allMatch(Ticket::rangeCheckForOneNumber);
    }

    private static boolean rangeCheckForOneNumber(int number) {
        return (LOWER_LIMIT_OF_NUMBER <= number) && (number <= UPPER_LIMIT_OF_NUMBER);
    }

    /* 숫자 정보가 변경되는 것을 막기 위해 복사하여 전달한다. */
    public Set<Integer> getNumberData(){
        return new HashSet<>(numbers);
    }

    public Rank getOrder(WinnerBalls balls) {
        if(isOrder1_CompareWith(balls)){ return Rank.FIRST; }
        if(isOrder2_CompareWith(balls)){ return Rank.SECOND; }
        if(isOrder3_CompareWith(balls)){ return Rank.THIRD; }
        if(isOrder4_CompareWith(balls)){ return Rank.FOURTH; }
        if(isOrder5_CompareWith(balls)){ return Rank.FIFTH; }
        return Rank.OUT;
    }

    /* 1위. 6개 일치 */
    private boolean isOrder1_CompareWith(WinnerBalls balls) {
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 6 == duplicatedNumberCount;
    }

    /* 2위. 5개 일치 and 보너스볼 일치 */
    private boolean isOrder2_CompareWith(WinnerBalls balls) {
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        boolean haveBonusBall = numbers.contains(balls.getBonusBall());
        return (haveBonusBall && (5 == duplicatedNumberCount));
    }

    /* 3위. 5개 일치 */
    private boolean isOrder3_CompareWith(WinnerBalls balls) {
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 5 == duplicatedNumberCount;
    }

    /* 4위. 4개 일치 */
    private boolean isOrder4_CompareWith(WinnerBalls balls) {
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 4 == duplicatedNumberCount;
    }

    /* 5위. 3개 일치 */
    private boolean isOrder5_CompareWith(WinnerBalls balls) {
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 3 == duplicatedNumberCount;
    }

    private int getDuplicatedNumberCount(Ticket other) {
        int count = 0;
        for(int number : numbers){
            count += other.isContain(number) ? 1 : 0;
        }
        return count;
    }

    public boolean isContain(int number){
        return numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(numbers, ticket.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}