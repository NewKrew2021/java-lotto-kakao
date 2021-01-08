package lotto.domain;

import java.util.Set;

public class WinningNumber extends LottoTicket {
    private Number bonusNumber;


    public WinningNumber(Set<Number> numbers, Number bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(Set<Number> numbers) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return super.toString() + " bonusNumber : " + bonusNumber;
    }
}
