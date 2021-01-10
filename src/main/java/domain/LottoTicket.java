package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Number> numbers;

    public LottoTicket(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int matchCount(LottoTicket otherTicket) {
        return (int) numbers.stream().filter(otherTicket::contains).count();
    }

    public LottoRank getRank(WinnerNumber winnerNumber) {
        int count = matchCount(winnerNumber);
        boolean bonus = contains(winnerNumber.getBonusNumber());
        return RankTable.get(count ,bonus);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
