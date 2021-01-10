package domain;

import java.util.Set;

public class WinnerNumber extends LottoTicket {
    private final Number bonusNumber;


    public WinnerNumber(Set<Number> numbers, Number bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Number getBonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " bonusNumber : " + bonusNumber;
    }
}
