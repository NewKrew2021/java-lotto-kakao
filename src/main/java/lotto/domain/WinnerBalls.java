package lotto.domain;

import lotto.domain.exceptions.BadWinnerBallsException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerBalls {
    private static final int WINNING_NUMBER_SIZE = 6;
    private final Set<Integer> winningNumbers;
    private final int bonusBall;

    public WinnerBalls(List<Integer> winningNumbers, int bonusBall) {
        if(!isValid(winningNumbers, bonusBall)){
            throw new BadWinnerBallsException("잘못된 당첨정보입니다.");
        }
        this.winningNumbers = new HashSet<>(winningNumbers);
        this.bonusBall = bonusBall;
    }

    private boolean isValid(List<Integer> initialWinningNumbers, int bonusBall) {
        Set<Integer> compressedNumbers = new HashSet<>(initialWinningNumbers);

        if(중복이_존재하는_당첨번호(initialWinningNumbers.size(), compressedNumbers.size())) {
            return false;
        }
        if(유효하지않은_당첨번호의_개수(compressedNumbers.size())) {
            return false;
        }
        if(당첨번호에_보너스볼이_포함(compressedNumbers, bonusBall)) {
            return false;
        }
        if(범위를_벗어나는_로또번호가_존재(compressedNumbers, bonusBall)) {
            return false;
        }
        return true;
    }

    private static boolean 중복이_존재하는_당첨번호(int givenSize, int compressedSize) {
        return compressedSize < givenSize;
    }

    private static boolean 유효하지않은_당첨번호의_개수(int size) {
        return size != WINNING_NUMBER_SIZE;
    }

    private static boolean 당첨번호에_보너스볼이_포함(Set<Integer> givenWinningNumbers, int bonusBall) {
        return givenWinningNumbers.contains(bonusBall);
    }

    private static boolean 범위를_벗어나는_로또번호가_존재(Set<Integer> givenWinningNumbers, int bonusBall) {
        boolean result = 로또번호가_정의된_범위를_벗어남(bonusBall);

        for (int number : givenWinningNumbers) {
            result |= 로또번호가_정의된_범위를_벗어남(number);
        }

        /*
         * 한번이라도 범위에 벗어나는 숫자가 있다면, result는 true(범위를 벗어나는 로또번호가 존재함) 가 된다.
         * 모든 숫자가 범위안에 있어야지 result는 false(범위를 벗어나는 로또번호가 존재하지 않음) 가 된다.
         * */
        return result;
    }

    private static boolean 로또번호가_정의된_범위를_벗어남(int number) {
        return number < Ticket.LOWER_LIMIT_OF_NUMBER || Ticket.UPPER_LIMIT_OF_NUMBER < number;
    }

    /* 당첨번호와 구입한 티켓의 번호를 비교하여 Rank를 반환한다. */
    public Rank getRankOf(Ticket buyingTicket) {
        int matchCount = getMatchCountComparedWith(buyingTicket);
        boolean matchBonusBall = buyingTicket.isContain(bonusBall);
        return Rank.getRankAccordingTo(matchCount, matchBonusBall);
    }

    private int getMatchCountComparedWith(Ticket buyingTicket) {
        return (int) winningNumbers.stream()
                .filter(buyingTicket::isContain)
                .count();
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
