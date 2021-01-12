package lotto.domain;


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
        invalidWinningNumberCheck(winningNumber);
    }

    private void invalidWinningNumberCheck(String winningNumber){
        if (Arrays.stream(winningNumber
                .replaceAll(" ", "")
                .split(","))
                .map(Integer::valueOf)
                .map(Number::new)
                .collect(Collectors.toList()).contains(bonusNumber)){
            throw new InvalidBonusNumber();
        }
    }

    public boolean bonusNumberContain(LottoTicket lottoTicket){
        return lottoTicket.contains(bonusNumber);
    }


    @Override
    public String toString() {
        return super.toString() + " bonusNumber : " + bonusNumber;
    }
}
