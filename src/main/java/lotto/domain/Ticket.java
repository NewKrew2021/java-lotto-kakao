package lotto.domain;

import lotto.setting.Format;
import lotto.setting.Rank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ticket {

    private final Set<Integer> numbers;

    public Ticket(Set<Integer> numbers){
        sizeCheck(numbers.size());
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void sizeCheck(int size){
        if(Format.TICKET_SIZE != size){
            throw new RuntimeException("invalid Ticket size!!");
        }
    }

    private void rangeCheck(Set<Integer> numbers){
        for (Integer number : numbers) {
            rangeCeckForOneNumber(number);
        }
    }

    private void rangeCeckForOneNumber(int number){
        if(number < Format.LOWER_LIMIT_OF_NUMBER || Format.UPPER_LIMIT_OF_NUMBER < number){
            throw new RuntimeException("contains invalid number value.");
        }
    }

    /* 숫자 정보가 변경되는 것을 막기 위해 복사하여 전달한다. */
    public Set<Integer> getNumberData(){
        return new HashSet<>(numbers);
    }

    public Rank getOrder(WinnerBalls balls){
        if(isOrder1_CompareWith(balls)){ return Rank.FIRST; } //TODO use enum to order number
        if(isOrder2_CompareWith(balls)){ return Rank.SECOND; }
        if(isOrder3_CompareWith(balls)){ return Rank.THIRD; }
        if(isOrder4_CompareWith(balls)){ return Rank.FOURTH; }
        if(isOrder5_CompareWith(balls)){ return Rank.FIFTH; }
        return Rank.OUT;
    }

    /* 1위. 6개 일치 */
    private boolean isOrder1_CompareWith(WinnerBalls balls){
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 6 == duplicatedNumberCount;
    }

    /* 2위. 5개 일치 and 보너스볼 일치 */
    private boolean isOrder2_CompareWith(WinnerBalls balls){
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        boolean haveBonusBall = numbers.contains(balls.getBonusBall());
        return (haveBonusBall && (5 == duplicatedNumberCount));
    }

    /* 3위. 5개 일치 */
    private boolean isOrder3_CompareWith(WinnerBalls balls){
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 5 == duplicatedNumberCount;
    }

    /* 4위. 4개 일치 */
    private boolean isOrder4_CompareWith(WinnerBalls balls){
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 4 == duplicatedNumberCount;
    }

    /* 5위. 3개 일치 */
    private boolean isOrder5_CompareWith(WinnerBalls balls){
        int duplicatedNumberCount = getDuplicatedNumberCount(balls.getTicket());
        return 3 == duplicatedNumberCount;
    }


    private int getDuplicatedNumberCount(Ticket other){
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
