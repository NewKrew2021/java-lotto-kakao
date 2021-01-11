package lotto.domain.game;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.List;

public class WinnerTicket {

    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    private WinnerTicket(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }

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
