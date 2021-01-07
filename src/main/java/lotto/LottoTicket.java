package lotto;

import java.util.Set;

public class LottoTicket {
    Set<Number> numbers;

    public LottoTicket(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int matchCount(LottoTicket compTicket) {
        return (int) numbers.stream().filter(compTicket::contains).count();
    }
}
