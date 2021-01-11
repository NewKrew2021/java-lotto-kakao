package domain;

import exception.DuplicateBonusNumberException;
import exception.InvalidCountException;

import java.util.Set;

import static domain.LottoConstant.LOTTO_NUMBER_COUNT;

public class WinnerNumber extends LottoTicket {
    private final Number bonusNumber;


    public WinnerNumber(Set<Number> numbers, Number bonusNumber) {
        super(numbers);
        if (numbers.contains(bonusNumber)) {
            throw new DuplicateBonusNumberException(bonusNumber + "");
        }
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
