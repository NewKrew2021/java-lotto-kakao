package lotto.domain.game;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.List;

public class WinnerTicket {
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    private WinnerTicket(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerTicket of(List<Integer> winnerNumbers, int bonusNumber) {
        return new WinnerTicket(LottoNumbers.from(winnerNumbers), LottoNumber.valueOf(bonusNumber));
    }

    public int countMatchingNumber(LottoNumbers lottoNumbers) {
        return winnerNumbers.countMatchingNumber(lottoNumbers);
    }

    public boolean hasBonus(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public LottoNumbers getWinnerNumbers() {
        return winnerNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
