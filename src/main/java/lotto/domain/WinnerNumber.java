package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinnerNumber {
    private final Set<Number> numbers;
    private final Number bonusNumber;


    public WinnerNumber(Set<Number> numbers, Number bonusNumber) {
        BallCountChecker.checkBallCount(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumber from(List<Integer> numbers, int bonusNumber) {
        return new WinnerNumber(new TreeSet<Number>(numbers.stream().map(Number::new).collect(Collectors.toList())), new Number(bonusNumber));
    }

    public LottoRank getRank(LottoTicket lottoTicket) {
        return LottoRank.get(new MatchResult(matchCount(lottoTicket), lottoTicket.contains(bonusNumber)));
    }

    private int matchCount(LottoTicket comparedTicket) {
        return (int) numbers.stream().filter(comparedTicket::contains).count();
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]" + " bonusNumber : " + bonusNumber;
    }
}
