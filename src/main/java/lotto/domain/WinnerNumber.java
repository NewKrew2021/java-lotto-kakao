package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinnerNumber extends LottoTicket {
    private final Number bonusNumber;


    public WinnerNumber(Set<Number> numbers, Number bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumber from(List<Integer> numbers, int bonusNumber) {
        return new WinnerNumber(new TreeSet<Number>(numbers.stream().map(Number::new).collect(Collectors.toList())), new Number(bonusNumber));
    }

    public Number getBonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " bonusNumber : " + bonusNumber;
    }
}
