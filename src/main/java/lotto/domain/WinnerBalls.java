package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerBalls {
    private static final int WINNING_NUMBER_SIZE = 6;
    private final Set<Integer> winningNumbers;
    private final int bonusBall;

    public WinnerBalls(List<Integer> winningNumbers, int bonusBall) {
        if(!isValid(winningNumbers, bonusBall)){
            throw new IllegalArgumentException("우승자 정보 매개변수 전달과정에서 예외 발생");
        }
        this.winningNumbers = new HashSet<>(winningNumbers);
        this.bonusBall = bonusBall;
    }

    public static boolean isValid(List<Integer> initialWinningNumbers, int bonusBall){
        if(WINNING_NUMBER_SIZE != initialWinningNumbers.size()){
            return false;
        }

        Set<Integer> compressedNumbers = new HashSet<>(initialWinningNumbers);
        if(WINNING_NUMBER_SIZE != compressedNumbers.size()) return false;
        if(compressedNumbers.contains(bonusBall)) return false;
        if(existInvalidNumberIn(compressedNumbers)) {
            return false;
        }
        if(bonusBall < Ticket.LOWER_LIMIT_OF_NUMBER || Ticket.UPPER_LIMIT_OF_NUMBER < bonusBall) {
            return false;
        }

        return true;
    }

    private static boolean existInvalidNumberIn(Set<Integer> numbers){
        boolean result = false;
        for (int number : numbers) {
            //한번이라도 invalid number가 발생하면, true를 or한다. 따라서 result는 true가 된다.
            result |= (number < Ticket.LOWER_LIMIT_OF_NUMBER);
            result |= (Ticket.UPPER_LIMIT_OF_NUMBER < number);
        }
        return result;
    }

    /* 당첨번호와 구입한 티켓의 번호를 비교하여 일치하는 것의 개수를 반환한다. */
    public int getMatchCountComparedWith(Ticket buyingTicket) {
        return (int) winningNumbers.stream()
                .filter(buyingTicket::isContain)
                .count();
    }

    public int getBonusBall(){
        return bonusBall;
    }
}
