package lotto.domain;

import lotto.view.InputView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber extends LottoTicket {
    private Number bonusNumber;

    public WinningNumber(String winningNumber, int bonusNumber){
        super(Arrays.stream(winningNumber
                .replaceAll(" ", "")
                .split(","))
                .map(Integer::valueOf)
                .map(Number::new)
                .collect(Collectors.toSet()));
        this.bonusNumber = new Number(bonusNumber);

    }

    public boolean contains(Set<Number> numbers) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return super.toString() + " bonusNumber : " + bonusNumber;
    }
}
