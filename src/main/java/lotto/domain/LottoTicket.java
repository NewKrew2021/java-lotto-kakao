package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int BALL_COUNT = 6;
    private final Set<Number> numbers;

    public LottoTicket(Set<Number> numbers) {
        checkBallCount(numbers);
        this.numbers = numbers;
    }

    private void checkBallCount(Set<Number> numbers) {
        if(numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력해 주세요.");
        }
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int matchCount(LottoTicket compTicket) {
        return (int) numbers.stream().filter(compTicket::contains).count();
    }

    public LottoRank getRank(WinnerNumber winnerNumber) {
        return RankTable.get(new MatchResult(matchCount(winnerNumber), contains(winnerNumber.getBonusNumber())));
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

}
