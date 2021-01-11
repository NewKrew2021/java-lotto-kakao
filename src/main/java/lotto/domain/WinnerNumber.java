package lotto.domain;

import java.util.*;

public class WinnerNumber {
    private final String DUPLICATE_NUMBER_ERROR = "중복된 숫자가 있습니다.";

    private final LottoTicket winnerNumbers;
    private final Number bonusNumber;

    public WinnerNumber(LottoTicket winnerNumbers, Number bonusNumber) {
        checkDuplication(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumber from(String input, int bonusNumber) {
        return new WinnerNumber(LottoTicket.from(input), Number.of(bonusNumber));
    }

    public LottoRank getRank(LottoTicket lottoTicket) {
        return LottoRank.get(winnerNumbers.matchCount(lottoTicket), lottoTicket.contains(bonusNumber));
    }

    private void checkDuplication(LottoTicket winnerNumbers, Number bonusNumber) {
        if(winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerNumber that = (WinnerNumber) o;
        return Objects.equals(winnerNumbers, that.winnerNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers, bonusNumber);
    }

    @Override
    public String toString() {
        return winnerNumbers + " bonusNumber : " + bonusNumber;
    }
}
