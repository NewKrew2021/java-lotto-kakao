package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ticket {

    private static final int TICKET_SIZE = 6;
    private final Set<Integer> numbers; //TODO 일급 콜렉션

    public Ticket(Set<Integer> numbers){
        sizeCheck(numbers.size());
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void sizeCheck(int size){
        if(TICKET_SIZE != size){
            throw new RuntimeException("invalid Ticket size!!");
        }
    }

    private void rangeCheck(Set<Integer> numbers){
        for (Integer number : numbers) {
            rangeCeckForOneNumber(number);
        }
    }

    private void rangeCeckForOneNumber(int number){
        if(number < 1 || 45 < number){
            throw new RuntimeException("contains invalid number value.");
        }
    }

    /* 숫자 정보가 변경되는 것을 막기 위해 복사하여 전달한다. */
    public Set<Integer> getNumberData(){
        return new HashSet<>(numbers);
    }

    public int getOrder(WinnerBalls balls){
        if(isOrder1_CompareWith(balls)){ return 1; } //TODO use enum to order number
        if(isOrder2_CompareWith(balls)){ return 2; }
        if(isOrder3_CompareWith(balls)){ return 3; }
        if(isOrder4_CompareWith(balls)){ return 4; }
        if(isOrder5_CompareWith(balls)){ return 5; }
        return 6;
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
        return (5 == duplicatedNumberCount) && haveBonusBall;
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
