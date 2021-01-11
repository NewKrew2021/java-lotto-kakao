package domain;

import exception.InvalidCountException;
import view.LottoGameView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final static int NUMBER_COUNT = 6;
    private final Set<Number> numbers;

    protected LottoTicket(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket of(String str) {
        Set<Number> number = Arrays.stream(str
                .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::from).collect(Collectors.toSet());
        if (number.size() != NUMBER_COUNT) {
            throw new InvalidCountException(number.size());
        }
        return new LottoTicket(number);
    }

    public static LottoTicket ofSet(Set<Number> numbers) {
        return new LottoTicket(numbers);
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
        return RankTable.get(count, bonus);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
