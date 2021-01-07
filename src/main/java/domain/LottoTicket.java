package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private Set<Number> numbers;

    public LottoTicket(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int matchCount(LottoTicket compTicket) {
        return (int) numbers.stream().filter(compTicket::contains).count();
    }

    public LottoRank getRank(WinnerNumber winnerNumber) {
        int count = matchCount(winnerNumber);
        boolean bonus = this.contains(winnerNumber.getBonusNumber());
        return RankTable.get(count * 10 + (bonus && count == 5 ? 1 : 0));
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
